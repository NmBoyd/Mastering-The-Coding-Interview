# This script will print all purmutations of a string. 
# It assumes assume characters are unique

import argparse

ap = argparse.ArgumentParser()
ap.add_argument("-s","--string",required=True,
    help = "string of characters")

# example string: abcdefg
