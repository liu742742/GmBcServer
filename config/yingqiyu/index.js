module.exports = [
  {
    "file": "../pom.xml",
    "replace": [
      {
        "regex": "(<\\!--\\* tomcat configuration -->)(.|\\n)*(<\\!-- tomcat configuration \\*-->)",
        "content": "<url>http://115.233.227.46:7013/manager/text</url><username>tomcat</username><password>tomcat</password><server>a2d</server>"
      }
    ]  
  }
]