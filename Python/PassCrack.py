import random
import time
alphabet = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9","~","`","!","@","#","$","%","^","&","*","(",")","-","_","=","+","[","]","{","}","\\","|",";",":","'","\"",",","<",".",">","/","?"," "]
charset = []
foundword = ""
j = 0
print("Welcome to my program! This program takes an input string and a character set, and uses that character set to build guesses, which it then checks against the input string. Please, start small! It can take many many guesses to guess the string, and the time it takes to crack the input increases exponentially with the length of the input, even though you can expect anywhere from 1K to 10M guesses per second.")
while True:
    print("Lowercase characters? (y/n)")
    lowercase = input()
    if lowercase == "y":
        for i in range(26):
            charset.append(alphabet[i])
        break
    elif lowercase == "n":
        break
    else:
        print("Please enter valid input.")
while True:
    print("Uppercase characters? (y/n)")
    uppercase = input()
    if uppercase == "y":
        for i in range(26, 52):
            charset.append(alphabet[i])
        break
    elif uppercase == "n":
        break
    else:
        print("Please enter valid input.")
while True:
    print("Numbers? (y/n)")
    numbers = input()
    if numbers == "y":
        for i in range(52, 62):
            charset.append(alphabet[i])
        break
    elif numbers == "n":
        break
    else:
        print("Please enter valid input.")
while True:
    print("Special characters? (y/n)")
    special = input()
    if special == "y":
        for i in range(62, len(alphabet)):
            charset.append(alphabet[i])
        break
    elif special == "n":
        break
    else:
        print("Please enter valid input.")
if len(charset) == 0:
    print("Please don't leave charset empty.")
    exit()
while True:
    print("Input string:")
    word = input()
    if word == "":
        print("Please do not leave input blank.")
    else:
        break
start = time.time() * 1000
while True:
    for i in range(len(word)):
        rand = random.randint(0, len(charset)-1)
        foundword += charset[rand]
    if foundword == word:
        end = time.time() * 1000
        keyspace = (j/len(charset) ** len(word))*100;
        keyspace = str(keyspace)
        taken = (end - start) / 1000
        if taken != 0:
            per = j/taken
            per = str(per)
        else:
            print("Time taken was too small, time and iterations per second will list as 0")
            per = "0"
        j = str(j)
        taken = str(taken)
        print("Found input after " + j + " iterations, over " + taken + " seconds, (" + per + " iterations/sec) using " + keyspace + "% of the keyspace")
        break
    else:
        j += 1
        foundword = ""