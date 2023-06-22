// 내용의 값의 빈공백을 trim(앞/뒤)
String.prototype.trim = function() {
		var TRIM_PATTERN = /(^\s*)|(\s*$)/g;
		return this.replace(TRIM_PATTERN, "");
};

// E-Mail 검사
function isValidEmail(email) {
	var format = /^((\w|[\-\.])+)@((\w|[\-\.])+)\.([A-Za-z]+)$/;
    if (email.search(format) != -1)
        return true; //올바른 포맷 형식
    return false;
}

// 전화번호 검사
function isValidPhone(phone) {
	var format = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/;
    if (phone.search(format) != -1)
        return true; //올바른 포맷 형식
    return false;
}