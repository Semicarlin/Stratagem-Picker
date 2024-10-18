"""
Generates Java class containing SQL statements for inserting values within stratagems.csv into an SQLite database
"""

# Globals
filename = "stratagems.csv"
table_name_var = "tableName"
table_name = "stratagems"
java_file_path = "../code/app/src/main/java/com/example/stratagempicker/Model/PrePopulation.java"

def write_java(content):
    
	# Write strings into .java file
    with open(java_file_path, "w") as infile:
        
        # Write Java class containing attributes, functions, and strings to write in the following table
		# INSERT INTO STRATAGEMS values(id, name, input, callInTime, uses, cooldown, type, hasBackpack, isOwned)
        infile.write((
            """
package com.example.stratagempicker.Model;

public class PrePopulation {{

    private String {table_name_var} = \"{table_name}\";

    private int stratagemCount = {stratagem_count};

	private String[] stratagemStrings = {{
{stratagem_strings}
    }};

    public String[] getStratagemStrings() {{
        return stratagemStrings;
    }}

    public int getStratagemCount() {{
        return stratagemCount;
    }}
}}
			""".format(
                table_name = table_name,
                table_name_var = table_name_var,
                stratagem_count = len(content),
                stratagem_strings = ",\n".join(["\t\t" + (" ".join(["\"INSERT INTO \"", "+ %s +" % table_name_var, "\" VALUES(%s);\"" % ("'%s', '%s', '%s', %s, %s, %s, %s, %s, %s" % ((i,) + tuple(row.strip().split(","))))])) for i, row in enumerate(content)])
            )
        ).strip())

def main():

    # Open file and read contents
    with open(filename, encoding="utf8") as file:
        file.readline()
        content = file.readlines()

        # Write data into .db file
        write_java(content)
    
if __name__ == "__main__":
    main()