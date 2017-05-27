/**
 * 修改用户密码
 */
function changePassword(id) {
    update('修改密码','/system/me/changePwd');
}
function runBeforeSubmit(form) {
    console.log("runBeforeSubmit");
    return true ;
}

function runAfterSubmitSuccess(response) {
    console.log("runAfterSubmitSuccess");
}

function runAfterSubmit(response) {
    console.log("runAfterSubmit");
}
