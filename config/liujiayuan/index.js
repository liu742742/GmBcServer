module.exports = [
  {
    "file": "../pom.xml",
    "replace": [
      {
        "regex": "(<\\!--\\* tomcat configuration -->)(.|\\n)*(<\\!-- tomcat configuration \\*-->)",
        "content": "<url>http://localhost:8080/manager/text</url><username>tomcat</username><password>tomcat</password><server>a2d</server>"
      }
    ]  
  }
]