set projectLocation=\AmazonAssignment

cd %projectLocation%

D:

mvn clean test -DsuiteXmlFile=testng.xml
