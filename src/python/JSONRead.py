import json
import sys

if __name__ == "__main__":

   try:
      src = sys.argv[1]
      sts_cards = json.load(open(src))
   except Exception as exc:
      print(type(exc))
      print



   def pretty(dict_in, indent=0):
      for key, value in dict_in.items():
         print('\t' * indent + str(key))
         if isinstance(value, dict):
            pretty(value, indent+1)
         else:
            print('\t' * (indent+1) + str(value))
   

   pretty(sts_cards)
   