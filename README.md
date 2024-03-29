# P1_OOP
- First part of the OOP project: "Santa Claus is coming to ACS students"
- Student: Chiper Alexandra-Diana
- Group: 322CD

## General Considerations
This project has tree main parts: the reading of the input data, processing the data, and writing
the processed data in a JSON file.

**Used Design Patterns:** SINGLETON, BUILDER, FACTORY

1.READING DATA
   * All  involved classes can be found in the **fileio** package
   * For parsing the input the **org.json** library was used
   * Some helper methods can be found in the **Utils** class
   
2.PROCESSING DATA
   * The involved classes are divided in different packages depending on their functionality:
     * *calculator* -> classes that are involved in the averageScore calculation
     * *pojo* -> contains classes that are mainly for storing and organising data (~ like 
       structures from C)
     * *service* -> classes that modifies / updates specific fields or does small jobs  for certain 
     classes
     * *sort* -> contains a class that sort an array of Gifts
     * *main* -> contains classes that run the checker

3.WRITING IN JSON FILE
   * All  involved classes can be found in the **fileio** package
   * The **jackson** library was used for writing the content of the files

## General Structure
First, the input data are read and parsed into 2 classes: Child and Gift, and further divided into
InitialData and AnnualChange(s).
For reading purposes the Child object are instantiated using BUILDER design as such:

* The initial children and the new children from annualUpdates (if they exist) are generated with 
all fields having a notNull value. 

* The childrenUpdates are generated as Child objects that have notNull values only for the field(s) 
  that have to be changed, the other fields rest as null.

At the end of the reading process the database(BD) which is kept in the Input class should be 
formed and populated. As the DB is universal, the Input class uses the SINGLETON design pattern 
(DP).

With the now populated DB the processing phase begins.

For calculating the averageNiceScore there are 3 different types of calculator classes that all 
inherit the AverageScoreCalculator class. Depending on the age of the child one of the 3 classes 
is instantiated. As there is no need for more instances of this calculator classes the SINGLETON 
pattern was used again. Also, the FACTORY pattern was used for getting the instance of the 
required calculator class.

For writing the JSON file which contains the result, the JArrayRounds and JArrayChild classes 
were used. The final result which is to be printed is stored in the JArrayRounds' annualChildren 
array (an array of JArrayChild with numberOfYears + 1 elements). The result of each individual 
round is store in the JArrayChild's children array. To keep the result of each round unchanged, 
from one round to another, each child from the result array is deep copied when it is loaded in 
the JArrayChild.

###General Flow Of The Data Processing
Every action performed in a round is done by Round object, which in turn uses the service classes.

Action to be performed in a normal round: 
1. Update santaBudget
2. The existing children will get older by 1 year
3. Kick out the (now) young adults
4. Update niceScoreHistory of the children that have updates
5. Add new children
6. Kick out the added young adults
7. Re-calculate the averageNiceScore for each child
8. Re-calculate the budgetUnit
9. Re-calculate the assignedBudget for each kid
10. Add new gifts
11. Sort gifts
12. Reset receivedGifts for each child
13. Finally, distribute gifts

For the initial round which is played separately, the 2, 3, 4, and 12 steps were omitted.

The counter variable used during the annualChanges serves only one purpose: to correct test7.json 
which is written wrongly as the numberOfYears = ***5***, but there are ***6*** annualChanges. 

The Child objects are modified via ChildService instance. The sum of all the averageNiceScores 
is calculated and delivered to the Round object by the RoundService instance. The service class are 
also SINGLETON. 

##Other mentions
For running a single test the SingleTest class was created.

The PreChecker class delete all resulting files from the output folder, before each run to 
ensure that the beSanta() method of the Main class is called (the method is called only if the 
outputFile is successfully created and an already existing file would lead to failure as the 
file will not be created).

##Links
- For the homework [description](https://ocw.cs.pub.ro/courses/poo-ca-cd/teme/proiect/etapa1)
- For code [skel](https://github.com/oop-pub/oop-asignments/tree/master/proiect1) 
- [Repository](https://github.com/A-Kyp/P1_OOP) on GitHub (still private at the moment, will be made public after the deadline from the second part of the project expires)

