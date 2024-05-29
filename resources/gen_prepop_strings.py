"""
Generates SQL statements for inserting values within stratagems_fixed.csv into an SQLite database
"""
import pandas as pd

def fix_data():
	"""
	Fixes data-specific problems
	"""
	# Get dataset
	data = pd.read_csv("stratagems.csv")
		
	# Make conversion dictionaries
	nums = {
		"one":1, 
		"two":2, 
		"three":3, 
		"four":4,
		"five":5,
		"six":6,
		"unlimited":"1e999",
		"immediate":0
	}
	arrows = {
		"▼":"d",
		"▲":"u",
		"►":"r",
		"◄":"l"
	}

	# Define conversion function
	def convert(val):
		val = val.lower().split()[0]
		if val in nums:
			return nums[val]
		elif val.isdigit():
			return int(val)
		elif val[0] in arrows:
			return "".join([arrows[char] for char in val])
		else:
			return pd.NA
	
	# Fix input
	data["input"] = data["input"].apply(convert)

	# Fix call-in time
	data["callInTime"] = data["callInTime"].apply(convert)
		
	# Fix cooldown
	data["cooldown"] = data["cooldown"].apply(convert)
	
	# Fix uses
	data["uses"] = data["uses"].apply(convert)
		
	# Save data
	data.to_csv("stratagems_fixed.csv", index=False)

def hex_form(i):
    # Converts integer i into 2-digit hexidecimal representation
    return ("0" + hex(i)[2:])[-2:]

def main():

    # Fix data
    fix_data()

    # Set constants
    filename = "stratagems_fixed.csv"
    table_name_var = "STRATAGEM_TABLE"
    id_col_var = "COL_STRATAGEM_ID"
    name_col_var = "COL_STRATAGEM_NAME"
    input_col_var = "COL_STRATAGEM_INPUT"
    call_in_time_col_var = "COL_STRATAGEM_CALL_IN_TIME"
    uses_col_var = "COL_STRATAGEM_USES"
    cooldown_col_var = "COL_STRATAGEM_COOLDOWN"
    owned_col_var = "COL_STRATAGEM_IS_OWNED"

    # Open file and read contents
    infile = open(filename, encoding="utf8")
    content = infile.readlines()
    infile.close()

    # Drop column name row
    content.pop(0)

    # Write strings into SQL File
    infile = open("prepop.java", "w")
    for i, row in enumerate(content):
        row = row.strip()

        # INSERT INTO STRATAGEMS values(id, name, input, callInTime, uses, cooldown)
        infile.write(" ".join(['"INSERT INTO "', "+ %s +" % table_name_var, '" VALUES(%s);"' % ("'%s', '%s', '%s', %s, %s, %s, 1" % ((hex_form(i),) + tuple(row.split(","))))]))
        if i < len(content) - 1:
            infile.write(" +\n")
		
    infile.close()
    

if __name__ == "__main__":
    main()