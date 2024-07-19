"""
Generates db from one or multiple csv file(s)
"""
import sqlite3
import sys
import os

# Classes
class CSV:
    """
    Represents a CSV file that is to be written into a database
    """
    def __init__(self):
        """
        Initializes CSV object
        """

# Functions
def get_paths():
    """
    Returns path to .csv and folder for .db
    Checks command line arguments first
    Otherwise, prompts user for input
    Returns: tuple of 2 strings representing file paths
    """
    csv_paths = []
    db_path = ""

    # Get command line arguments
    for arg in sys.argv[1:]:

        # Check for csv path
        if arg[-4:] == ".csv" and os.path.exists(arg):
            try:
                open(arg).close()
            except:
                continue
            else:
                csv_paths.append(arg)

        # Check for db path
        elif os.path.exists(arg) and db_path == "":
            db_path = arg

        # Otherwise, arguement is db name
        else:
            db_name = arg

    # Check for missing csv path
    if csv_paths == []:
        print("No valid path to csv was provided.")
        while not os.path.exists(csv_path):
            csv_path = input("Enter path to csv file: ")

    # Check for missing db path
    if db_path == "":
        print("No valid path for database was provided.")
        while not os.path.exists(db_path):
            db_path = input("Enter path to database directory: ")

    # Return paths
    return csv_path, db_path

def read_csv(csv_path):
    """
    Opens file specified by file path and reads content and column names
    Returns: 1-D list of column names, 2-D list of csv contents
    """

    # Open file and read contents
    infile = open(csv_path)#, encoding="utf8")
    content = [line.strip().split(",") for line in infile.readlines()]
    infile.close()

    # Get column names
    cols = content.pop(0)

    # Return
    return cols, content

def is_col_int(j, content):
    """
    Checks whether all values within column j in content are integers
    Returns: True if all values within column j are int, False otherwise
    """
    for row in content:
        try:
            int(row[j])
        except ValueError:
            return False
        else:
            continue
    return True

def is_col_flt(j, content):
    """
    Checks whether all values within column j in content are floating-point (real) numbers
    Returns: True if all values within column j are float, False otherwise
    """
    for row in content:
        try:
            float(row[j])
        except ValueError:
            return False
        else:
            continue
    return True

def infer_types(cols, content):
    """
    Determine SQLite datatypes to use for each column
    Returns: list of strings of SQLite datatypes respective to columns
    """

    # Infer data type of every column
    types = []
    for j in range(len(cols)):

        # Call function to check column contents
        if is_col_int(j, content):
            types.append("INTEGER")
        elif is_col_flt(j, content):
            types.append("REAL")
        else:
            types.append("CHAR")

    # Return list of respective SQL datatypes
    return types

def get_db_name(csv_path):
    """
    Gets db name from csv file
    """
    return csv_path[csv_path.rfind("\\") + 1:csv_path.rfind(".csv")] + ".db"

def create_database(db_path):
    """
    Create database at desired destination
    Returns: connection to and cursor of database
    """
    
    # Create database file
    open(db_path, "w").close()

    # Open database with sqlite
    connection = sqlite3.connect(db_path)
    cursor = connection.cursor()

    # Return database connection and cursor
    return connection, cursor

def write_db(connection, cursor):
    """
    Creates table and writes content into db
    """

def main():
    """
    Main functionality
    """

    # Get file paths
    csv_path, db_path = get_paths()

    # Get columns and content from csv
    cols, content = read_csv(csv_path)

    # Get column types
    col_types = infer_types(cols, content)

    # Update db path
    db_path += get_db_name(csv_path)

    # Create database
    connection, cursor = create_database(db_path)

    # 

    # Print end
    print("  ##   ##  \n     #    \n  #     #  \n   #####")

if __name__ == "__main__":
    main()