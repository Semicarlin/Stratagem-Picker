"""
Generates Java class containing SQL statements for inserting values within stratagems.csv into an SQLite database
"""

# Globals
table_name_var = "stratagems"
filename = "stratagems.csv"
java_file_path = "../code/app/src/main/java/com/example/stratagempicker/Model/PrePopulation.java"

def write_java(content):
    
	# Write strings into .java file
    with open(java_file_path, "w") as infile:
        
        # Write Java class containing attributes, functions, and strings to write in the following table
		# INSERT INTO STRATAGEMS values(id, name, input, uses, type, hasBackpack, isOwned)
        # for id, row in enumerate(content):
        #     name, input, uses, strat_type, hasBackpack, isOwned = [col.strip("\n") for col in row.split(",")]
        #     print(
        #         "\t\t" + "Stratagem(%s)" % ("%s, \"%s\", \"%s\", %s, StratagemType.%s, %s, %s" % (id, name, input, uses, strat_type.upper(), hasBackpack, isOwned)) + ",\n",
        #         end=""
        #     )

        infile.write((
            """
package com.example.stratagempicker.Model;

public class PrePopulation {{

	private final Stratagem[] stratagems = {{
{stratagem_strings}
    }};

    public Stratagem[] getStratagems() {{
        return stratagems;
    }}
}}
			""".format(
                stratagem_strings = ",\n".join(
                    [
                        "\t\t" + "new Stratagem(%s)" % (
                            "%s, \"%s\", \"%s\", %s, StratagemType.%s, %s, %s" % (
                                id, # id
                                *[col.strip("\n") for col in row.split(",")[:2]], # name, input
                                row.split(",")[2] if row.split(",")[2] != "1e999" else "Integer.MAX_VALUE", # uses
                                row.split(",")[3].upper(), # type
                                row.split(",")[4], # hasBackpack
                                row.split(",")[5].strip("\n") # isOwned
                            )
                        ) for id, row in enumerate(content)
                    ]
                )
            )
        ).strip())

def main():

    # Open file and read contents
    with open(filename, encoding="utf8") as file:
        file.readline()
        content = file.readlines()

        # Write data into .db file
        write_java(content)

        # Print success message
        print("File written: %s" % java_file_path)
    
    
if __name__ == "__main__":
    main()