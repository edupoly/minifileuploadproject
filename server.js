var http = require('http');
var {Server} = require('socket.io');

var express = require('express');
var app = express();

var server = http.createServer(app);
var io = new Server(server);


var bodyParser = require('body-parser');
var fs = require('fs');

io.on('connection',function(socket){
    console.log("connection established")
});

var multer= require('multer');
// var uploads = multer({dest:__dirname+"/uploads"})//configuration
app.use(express.static(__dirname+"/public"))
app.use(bodyParser.urlencoded({extended:false}));


var storage = multer.diskStorage({
    destination:function(req,file,cb){
        cb(null,__dirname+"/uploads")
    },
    filename:function(req,file,cb){
        cb(null,file.originalname)
    }
})
var uploads = multer({storage})

app.post("/uploadFile",uploads.single('myfile'),function(req,res){
    console.log(req.body)
    console.log(req.file)
    
    fs.rename(__dirname+"/uploads/"+req.file.filename,__dirname+"/uploads/"+req.body.usename+"/"+req.file.originalname,function(err){
        if(err){
            res.send("Username invalid")
        }
        else{
            res.send("File Upload Success")
        }
    })
})
server.listen(3800,()=>{console.log("running on 3800")})