# Foondamate CLI


Welcome to the Foondamate Data VCLI.

#Prerequisites:
    
    Java 11 SE (required to run program)
    Maven      (Optional)

The product has already been packaged and can be found ("target/FoondamateCLI-1.0-SNAPSHOT-jar-with-dependencies.jar")

### Issues and their resolutions:
    java -jar target/FoondamateCLI-1.0-SNAPSHOT-jar-with-dependencies.jar

#### this command may yield and in app error such as below:
    Error, range (00-00-0000  -  00-00-0000) were not found
In this case please provide the CLI with arguments in the format "dd-MM-YYYY dd-MM-YYYY".

    java -jar target/FoondamateCLI-1.0-SNAPSHOT-jar-with-dependencies.jar 01-01-2022 10-01-2022


### The Bar Graph changes according to the range given alongside with the min and max values present. Be sure to experiment