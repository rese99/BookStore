var passwordObj;
var confirmObj;
var PhoneObj;

var passwordMsg;
var confirmMsg;
var PhoneMsg;

window.onload = function () {	// 页面加载之后, 获取页面中的对象
    passwordObj = document.getElementById("password");
    confirmObj = document.getElementById("repassword");
    PhoneObj = document.getElementById("telephone");

    passwordMsg = document.getElementById("passwordMsg");
    confirmMsg = document.getElementById("confirmMsg");
    PhoneMsg = document.getElementById("PhoneMsg");

};

function checkForm() {          // 验证整个表单
    var bPassword = checkPassword();
    var bConfirm = checkConfirm();
    var Phone = checkPhone();
    return bPassword && bConfirm && Phone; // return false后, 事件将被取消
}

function checkPassword() {		// 验证密码
    var regex = /^.{6,16}$/;			// 任意字符, 6到16位
    var value = passwordObj.value;
    var msg = "";
    if (!value)
        msg = "密码必须填写：";
    else if (!regex.test(value))
        msg = "密码不合法：";
    else msg = "密码设置至少6位，请区分大小写";
    passwordMsg.innerHTML = msg;
    passwordObj.parentNode.parentNode.style.color = msg == "密码设置至少6位，请区分大小写" ? "black" : "red";
    return msg == "";
}

function checkConfirm() {		// 验证确认密码
    var passwordValue = passwordObj.value;
    var confirmValue = confirmObj.value;
    var msg = "";
    if (!confirmValue) {
        msg = "确认密码必须填写";
    } else if (passwordValue != confirmValue) {
        msg = "密码必须保持一致";
    }
    confirmMsg.innerHTML = msg;
    confirmObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
    return msg == "";
}

function checkPhone() {
    var regex = /^1[3|4|5|7|8]\d{9}$/;
    var ID = PhoneObj.value;
    var msg = "";
    if (!ID)
        msg = "填写手机号码";
    else if (!regex.test(ID))
        msg = "请正确输入手机号码";
    PhoneMsg.innerHTML = msg;
    PhoneObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
    return msg == "";
}