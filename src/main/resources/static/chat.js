var url = "ws://localhost:8080/my-websocket";
var client = null;
var chatId = null;
var sender = null;
client = Stomp.client(url);
client.connect({}, onConnection);

function onConnection(){
	sender = document.getElementById("sender").textContent;
	chatId = document.getElementById("chatId").value;
	client.subscribe("/my-broker/"+chatId, onMessageFromServer);
}
function onMessageFromServer(message){
	var messageJSON = JSON.parse(message.body);
	var textMessage = "("+messageJSON.sender+" "+messageJSON.date+") "+messageJSON.value;
	outputMessage(textMessage);
}
function outputMessage(messsage){
	var output = document.getElementById("real-time-message");
	var newP = document.createElement("p");
	newP.appendChild(document.createTextNode(messsage));
	output.appendChild(newP);
}
function sendMessage(){
	var message = document.getElementById("message").value;
	var messageJSON = {sender:sender, date:null, value:message};
	client.send("/my-handlers/"+chatId, {chatId:chatId}, JSON.stringify(messageJSON));
	document.getElementById("message-area").innerHTML="<textarea rows='2' cols='25' id='message'></textarea>"
} 

