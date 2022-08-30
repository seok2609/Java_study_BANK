//member.js
const btn = document.getElementById("btn");
const form1 = document.getElementById("form1");
const userName = document.getElementById("userName");
const password = document.getElementById("password");
const d1 = document.getElementById("d1");

btn.addEventListener("click", function(){
    console.log("클릭");
    let u = userName.value;
    let p = password.value;
    console.log(u == "");
    console.log(u.length);

    if(u.length > 0 && p.length > 0){
        form1.submit();
    }else{
        d1.innerHTML='<h4>'+'</h4>';
    }

    // if(u == ""){
    //     alert("ID는 필수입니다.");
    //     return;
    // }

    // if(p == ""){
    //     alert("PW는 필수입니다.");
    //     return;
    // }

    // form1.submit();

    // if(u.length > 0 && p.length > 0){
    //     form1.submit();
    // }else{
    //     alert("아이디와 비밀번호 입력은 필수입니다.");
    // }
});


