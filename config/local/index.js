module.exports = [
  {
    "file": "../pom.xml",
	"replace": [
      {
        "regex": "(<\\!--\\* tomcat configuration -->)(.|\\n)*(<\\!-- tomcat configuration \\*-->)",
        "content": "<url>http://localhost:8080/manager/text</url><username>tomcat</username><password>tomcat</password><server>a2d</server>"
      }
    ]  
  },
  {
    "file": "../src/main/resources/application.properties",
    "replace": [
      {
        "regex": "(## mysql url #)(.|\\n)*(# mysql url ##)",
        "content": "spring.datasource.url=jdbc:mysql://115.233.227.46:7015/gmbcserver?characterEncoding=utf8&useUnicode=true&useSSL=true"
      },
      {
        "regex": "(## mysql username #)(.|\\n)*(# mysql username ##)",
        "content": "spring.datasource.username=root"
      },
      {
        "regex": "(## mysql password #)(.|\\n)*(# mysql password ##)",
        "content": "spring.datasource.password=root"
      }
    ]  
  }
]