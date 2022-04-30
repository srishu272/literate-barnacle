"""
Name: Srishu Chintakindi
ID: 20CE012
GitHub repositary link: https://github.com/srishu272/Python_Programming

Practical:
Write a program to compute the frequency of the words from the input. The output should output after sorting the key alphanumerically. 

Suppose the following input is supplied to the program: New to Python or choosing between Python 2 and Python 3? Read Python 2 or Python 3. 
Then, the output should be: 2:2 3:1 3?:1 New:1 Python:5 Read:1 and:1 between:1 choosing:1 or:2 to:1"""


string = input()
Mylist = []
str = ''
string = string + ' '
cnt_dict = {}


#Bubble sorting the list1 and swaping the values of list2 according to the swapping in list1
def Bubble_Sort(list1,list2):
    for i in range(1,len(list1)):
        for j in range(len(list1)-1):
            if(list1[j] > list1[j+1]):
                list1[j], list1[j+1] = list1[j+1], list1[j]
                list2[j], list2[j+1] = list2[j+1], list2[j]
    return list1    


#Loop for extracting each word from the input sentence and appending it into a list "Mylist"
for i in range(len(string)):
    if((string[i] != ' ') & (string[i] != '.')):
        str = str + string[i]
    else:
        Mylist.append(str)
        str=''

#Counting the frequency of each word in the input by using dictionary
for i in Mylist :
    if i in cnt_dict:
        cnt_dict[i] += 1
    else:
        cnt_dict[i] = 1

print(cnt_dict)

#Converting the dictionary keys and values into 2 different lists - "Mylist1" & "Mylist2"
Mylist1 = list(cnt_dict.keys())
Mylist2 = list(cnt_dict.values())

#Calling the bubble sort function
sorted_keys = Bubble_Sort(Mylist1,Mylist2)
k=0
#Printing the elements of the sorted list in the particular manner
for i in Mylist1:
    print(i,':',Mylist2[k])
    k = k+1
