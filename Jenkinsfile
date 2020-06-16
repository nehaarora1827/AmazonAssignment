pipeline
{
agent any
tools
{
   maven 'MVN_HOME'
}
stages
{
    stage('Checkout')
   {
      steps
     {
        checkout scm
     }
   }
    stage('Build')
   {
      steps
       {
         bat "mvn clean install"
       }
   }
}
}
