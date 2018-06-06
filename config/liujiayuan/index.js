module.exports = [
  {
    "file": "../pom.xml",
    "replace": [
      {
        "regex": "(<\\!--\\* tomcat configuration -->)(.|\\n)*(<\\!-- tomcat configuration \\*-->)",
        "content": "<url>http://115.233.227.46:7010/manager/text</url><username>admin</username><password>admin</password><update>true</update>"
      }
    ]  
  }
]