**Fruite basket application:**

application. The CSV-file represents a catalog of all the fruit in a fruit bowl. Each line is a
piece of fruit. The data representing a particular fruit include:
• fruit type
• age in days
• ad-hoc characteristic 1
• ad-hoc characteristic 2
leading to the following format:
`fruit-type,age-in-days,characteristic1,characteristic2
apple,1,red,sweet
orange,2,round,sweet
pineapple,5,prickly,sweet
apple,4,yellow,sweet
grapefruit,2,yellow,bitter`


**How to Run the application:**

Download the file: [Fruite_script.zip](https://github.com/Ravali-dev96/fruite-basket_app/blob/main/Fruite_script.zip)

**For Windows users:**
1. Extract the Fruite_script.zip
2. Open the folder Fruite_script
3. Open terminal and execute `run.bat <csv file path>`
   Example:`.\run.bat fruits.csv`

**For Linux/Mac users:**
1. Extract the Fruite_script.zip
2. Open the directory cd Fruite_script
3. Open terminal and execute `run.sh <csv file path>`
   Example:`.\run.sh fruits.csv`

The above script will result in output similar to the below:


Total number of fruit:
22

Total types of fruit:
5

Oldest fruit & age:
orange: 6
pineapple: 6

The number of each type of fruit in descending order:
orange: 6
apple: 5
pineapple: 4
grapefruit: 4
watermelon: 3

The various characteristics (count, color, shape, etc.) of each fruit by type:
5 orange: round, sweet
3 apple: red, sweet
2 pineapple: sweet, prickly
2 grapefruit: yellow, bitter
2 pineapple: prickly, sweet
2 watermelon: heavy, green
2 grapefruit: bitter, yellow
1 apple: green, tart
1 watermelon: green, heavy
1 apple: yellow, sweet
1 orange: sweet, round
