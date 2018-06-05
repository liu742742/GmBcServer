const fs = require('fs')
const path = require('path')

var args = process.argv.splice(2)
if (args.length < 1) {
	console.log('please input config name')
	return
}
const config = require('./' + args[0])

config.forEach(function (item, index) {
  let cotent = fs.readFileSync(path.join(__dirname, item.file), { 'encoding': 'utf8' })
  item.replace.forEach(function (item, index) {
  	console.log('regex: ' + item.regex);
    let regex = new RegExp(item.regex, "gi");
    console.log('matched content: ' + cotent.match(regex))
    cotent = cotent.replace(regex, '$1' + item.content + '$3')
  })
  fs.writeFileSync(path.join(__dirname, item.file), cotent, { 'encoding': 'utf8' })
})