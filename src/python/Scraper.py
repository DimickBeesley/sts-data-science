import bs4
from urllib.request import urlopen as uReq
from bs4 import BeautifulSoup as soup
import json


""" URLS """

ironclad_url        = "https://slay-the-spire.fandom.com/wiki/Ironclad_Cards"
silent_url          = "https://slay-the-spire.fandom.com/wiki/Silent_Cards"
defect_url          = "https://slay-the-spire.fandom.com/wiki/Defect_Cards"
watcher_url         = "https://slay-the-spire.fandom.com/wiki/Watcher_Cards"
colorless_url       = "https://slay-the-spire.fandom.com/wiki/Colorless_Cards"
status_url          = "https://slay-the-spire.fandom.com/wiki/Status"
curse_url           = "https://slay-the-spire.fandom.com/wiki/Curse"


""" LISTS """

urls =              [ironclad_url, silent_url, defect_url, watcher_url, colorless_url, status_url, curse_url]
vals =              []
cards_seperated =   []



""" FUNCS """

# Scrape raw elements from the html
def scrape_vals(url_in):
    # opens connection, grabs page
    uClient = uReq(url_in)
    page_html = uClient.read()
    uClient.close()

    # html parsing
    page_soup = soup(page_html, "html.parser")
    page_soup.prettify()
    vals_out = page_soup.findAll("td")
    
    return vals_out



# Adds element for each page to vals
def fill_vals():
    for url in urls:
        vals.append(scrape_vals(url))



# Takes the raw elements and seperates them into cards
def vals_to_cards(target, val_per_card):
    counter = 0
    cards_out = []

    while (counter + val_per_card <= len(target)):
        cards_out.append(target[counter: counter + val_per_card])
        counter += val_per_card

    return cards_out



def fill_cards_seperated():
    
    cards_seperated.append(vals_to_cards(vals[0], 6))
    cards_seperated.append(vals_to_cards(vals[1], 6))
    cards_seperated.append(vals_to_cards(vals[2], 6))
    cards_seperated.append(vals_to_cards(vals[3], 6))
    cards_seperated.append(vals_to_cards(vals[4], 6))

    cards_seperated.append(vals_to_cards(vals[5], 4))
    cards_seperated.append(vals_to_cards(vals[6], 4))



''' for JSON printing later '''
def pretty(dict_in, indent=0):
   for key, value in dict_in.items():
      print('\t' * indent + str(key))
      if isinstance(value, dict):
         pretty(value, indent+1)
      else:
         print('\t' * (indent+1) + str(value))



fill_vals()
fill_cards_seperated()



""" using get_text() to make cards into dicts, and very innefficiently """

sts_card_dictionary = {"The Ironclad": {}, "The Silent": {}, "The Defect": {}, "The Watcher": {}, "Colorless": {}, "Status": {}, "Curse": {}}



def make_card_dict(color_ind, card_ind, mode):
    
    dict_title = ""
    dict_contents = []
    counter = 2
    
    if mode == 'p': # playable
        dict_title = cards_seperated[color_ind][card_ind][0].get_text().strip()
        while counter < 6:
            dict_contents.append(cards_seperated[color_ind][card_ind][counter].get_text().strip())
            counter += 1

        dict_out = {dict_title: dict_contents}
    
    elif mode == 's': # status
        dict_title = cards_seperated[color_ind][card_ind][0].get_text().strip()
        while counter < 4:
                dict_contents.append(cards_seperated[color_ind][card_ind][counter].get_text().strip())
                counter += 1

        dict_out = {dict_title: dict_contents}
    
    elif mode == 'c': # curse
        dict_title = cards_seperated[color_ind][card_ind][0].get_text().strip()
        while counter < 3:
                dict_contents.append(cards_seperated[color_ind][card_ind][counter].get_text().strip())
                counter += 1

        dict_out = {dict_title: dict_contents}

    return dict_out



card_range_chars = range(0,74)
card_range_colorless = range(0,47)
card_range_status = range(0, 4)
card_range_curse = range(0,13)



for i in card_range_chars:
    sts_card_dictionary["The Ironclad"].update(make_card_dict(0, i, 'p'))

for i in card_range_chars:
    sts_card_dictionary["The Silent"].update(make_card_dict(1, i, 'p'))

for i in card_range_chars:
    sts_card_dictionary["The Defect"].update(make_card_dict(2, i, 'p'))

for i in card_range_chars:
    sts_card_dictionary["The Watcher"].update(make_card_dict(3, i, 'p'))

for i in card_range_colorless:
    sts_card_dictionary["Colorless"].update(make_card_dict(4, i, 'p'))

for i in card_range_status:
    sts_card_dictionary["Status"].update(make_card_dict(5, i, 's'))

for i in card_range_curse:
    sts_card_dictionary["Curse"].update(make_card_dict(6, i, 'c'))



# Because for some reason the finished product skipped the last element of each of the card tables
sts_card_dictionary["The Ironclad"].update({"Reaper": ["Rare", "Attack", "2", "Deal 4(5) damage to ALL enemies. Heal for unblocked damage dealt. Exhaust."]})
sts_card_dictionary["The Silent"].update({"Wraith Form": ["Rare", "Power", "3", "Gain 2(3) Intangible. At the end of your turn, lose 1 Dexterity"]})
sts_card_dictionary["The Defect"].update({"Thunder Strike": ["Rare", "Attack", "3", "Deal 7(9) damage to a random enemy for each Lightning Channeled this combat."]})
sts_card_dictionary["The Watcher"].update({"Wish": ["Rare", "Skill", "3", "Choose one: Gain 6(8) Plated Armor, 3(4) Strength, or 25(30) Gold. Exhaust."]})
sts_card_dictionary["Colorless"].update({"Through Violence": ["Special", "Attack", "0", "Retain. Deal 20(30) damage. Exhaust. (Obtained from Reach Heaven)."]})
sts_card_dictionary["Status"].update({"Void": ["Status", "Unplayable. When this card is drawn, lose 1 Energy. Ethereal."]})
sts_card_dictionary["Curse"].update({"Writhe": ["Unplayable. Innate"]})

for color in sts_card_dictionary.values():
    for card in color.values():
        for item in card:
            item = item.replace("\n", " ")

print("Writing this:\n")
pretty(sts_card_dictionary)

j = json.dumps(sts_card_dictionary)
with open('STSCards.json', 'w') as file:
    file.write(j)
    file.close()

    
