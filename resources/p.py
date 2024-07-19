infile = open("stratagems_fixed.csv", encoding="utf8")
content = infile.readlines()
infile.close()
infile = open("stratagems_fixed.csv", "w")
for line in content:
    infile.write(line)
infile.close()