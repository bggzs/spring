var code;
function createCode() {
	document.getElementById('checkCode').value="";
	code="";
	var codeLength=6;
	var checkCode=document.getElementById('checkCode');
	var selectChar = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');

	for(var i=0;i<codeLength;i++){
		var charIndex=Math.floor(Math.random()*36);
		code+=selectChar[charIndex];
		document.getElementById('checkCode').value+=selectChar[charIndex];
	}
	

}
var incode=false;
function validate() {
	var inputCode=document.getElementById('input1').value;
	inputCode=inputCode.toLowerCase();
	code=code.toLowerCase();
	if(inputCode.length<=0){
		document.getElementById('code').innerHTML="请输入验证码";
	}else if(inputCode!==code){
		alert("验证码输入错误");
		createCode();
		incode=false;
	}else{
		incode=true;
	}	
	
}
function Mylogin(){
	var act=$('#account').val();
	var pwd=$('#password').val();
	
	$.ajax({
		type:"POST",
		url:"./Ajax_let1",
		data:{
			key1:act,
			key2:pwd
			},
		statusCode : {
			404 : function() {
				alert("404");
			},
			500 : function() {
				alert("500");
			}
		},
		success : function(massge, Status) {
			if(massge=="1"){
				window.location.href = 'index.html';
			}else{
				alert("密码错误");
				window.location.href="login-page.html";
				
			}
		} 
	});
}

