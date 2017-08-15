# Find Elapsed Days between two given dates

An application to calculate the full elapsed days between any two given dates excluding the given dates. Application accepts input from command-Line/Terminal.

## PROBLEM
You have joined a science project as the latest team member. Scientists on the project are running a series of experiments and need to calculate the number of full days elapsed in between the experiment’s start and end dates, i.e. the first and the last day are considered partial days and never counted. Following this logic, an experiment that has run from 07/11/1972 and 08/11/1972 should return 0, because there are no fully elapsed days contained in between those dates, and 01/01/2000 to 03/01/2000 should return 1. The solution needs to cater for all valid dates between 01/01/1901 and 31/12/2999.

### TEST CASES (DD/MM/YYYY)
1. 02/06/1983 - 22/06/1983: 19 days
2. 04/07/1984 - 25/12/1984: 173 days
3. 03/08/1983 - 03/01/1989: 1979 days

## Getting Started

To compile and run the application and tests on your local machine, download the Source (com) to a local directory on your local machine. JUnit Test cases are also included. Alternatively you can download the project to IDE like Eclipse or IntelliJ Idea.

### Pre-requisites

To run the application you need Java Runtime Environment 8 on your local machine which can be downloaded from the below link.
* [JRE Download](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)

To compile the application you need Java Development Kit 8 on your local machine which can be downloaded from the below link.
* [JDK Download](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

To run the tests you need JUnit which can be downloaded and installed from the below link. Alternatively you can include following JARs in your test classpath:
* [JUnit Download](https://github.com/junit-team/junit4/wiki/Download-and-Install)
* junit-4.12.jar
* hamcrest-all-1.3.jar

## Compiling the application

1. Open Command-Line or Terminal on you local machine.
2. Change the directory to parent directory of the extracted FindElapsedDays.zip file.
3. Compile the application as below.

```
$ javac com/myndful/challenge/FindElapsedDays.java
```

## Running the application

1. Open Command-Line or Terminal on you local machine.
2. Change the directory to parent directory of the source.
3. Input Start date and End date in Command-Line or Terminal. Both dates should be in DD/MM/YYYY format and ensure Start date is before End date for correct result.
4. Run the application as below.

```
$ java com/myndful/challenge/FindElapsedDays 01/02/2011 15/02/2011

Result:

Full days elapsed between 01/02/2011 and 15/02/2011 : 13
```

## Running the tests

1. Open Command-Line or Terminal on you local machine.
2. Change the directory to parent directory of the source (com).
3. Ensure following JARs are in your classpath:
* junit-4.12.jar
* hamcrest-all-1.3.jar

4. compile tests cases as below.

```
$ javac com/myndful/challenge/FindElapsedDaysTest.java com/myndful/challenge/TestRunner.java
```

5. Run tests as below.

```
$ java com/myndful/challenge/TestRunner
```

Note: All the test cases mentioned in the problem statement along with some additional test cases are included in the tests.

## Built With

* [JAVA 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

## Authors

* **Pavan Kumar** - *Initial work*
