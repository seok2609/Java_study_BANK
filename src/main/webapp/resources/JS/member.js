function logincheck(){
    const btn1 = document.getElementById("btn1");
    const form1 = document.getElementById("form1")
    const id = document.getElementById("userName");
    const pw = document.getElementById("exampleInputPassword1");
    const d1 = document.getElementById("d1");
    
    btn1.addEventListener("click", function(){
    
        let u = id.value;
        let p = pw.value;
        console.log(u.length); 
    
    
        if(p.length==0){
            d1.innerHTML='비밀번호를 입력하세요ㅋ'
            return;
        }else if(u.length==0){
            d1.innerHTML='아이디를 입력하세요ㅋ'
        return; 
        }
        
        if(p.length>0 && u.length>0){form1.submit();}
    });
    
    }
    
    function check(){
    
        const all = document.getElementById("all");
        const cb = document.getElementsByClassName("cb");
        const req = document.getElementsByClassName("req");
        const join = document.getElementById("join");
        const frm = document.getElementById("frm");
    
    
   
    
        all.addEventListener("click", function(){
        
            
                for(let i=0;i<cb.length;i++){
                    cb[i].checked = all.checked;
                }
            });
    
        for(let i=0;i<cb.length;i++){
            
            cb[i].addEventListener("click", function(){
                let result = true;
                for(let j=0;j<cb.length;j++){
                    if(!cb[j].checked){
                        result = false;
                        break;
                    }else{
                        result = true;
                        break;
                    }
                }
                    all.checked=result;
            });
        }
         
        join.addEventListener("click", function(){
    
            let result =true;
            for(let j=0;j<req.length;j++){
                if(!req[j].checked){
                    result = false;
                    break;
                }
            }
    
            if (result){
                frm.submit();
            }else{
                alert("필수 약관동의하삼")
            }
                
        });
    
    
    
    
    
    
    }
    
    
    function checkjoin(){
    
        const btn = document.getElementById("btn");
        const uname = document.getElementById("inputUserName");
        const pw = document.getElementById("inputPassword");
        const pw2 = document.getElementById("inputPassword2");
        const name = document.getElementById("inputName");
        const email = document.getElementById("inputEmail");
        const phone = document.getElementById("inputPhone");
    
        const d1 = document.getElementById("d1");
        const d2 = document.getElementById("d2");
        const d3 = document.getElementById("d3");
        const d4 = document.getElementById("d4");
        const d5 = document.getElementById("d5");
        const d6 = document.getElementById("d6");
    
        const frm = document.getElementById("frm");
    
    
    
    
        btn.addEventListener("click", function(){
    
            // let u = uname.value;
            // let p = pw.value;
            // let p2 = pw2.value;
            // let n = name.value;
            // let e = email.value;
            // let ph = phone.value;
    
            let unameCheck=false;
            let pwCheck=false;
            let pw2Check=false;
            let nameCheck=false;
            let emailCheck=false;
            let phoneCheck=false;
    
            if(unameCheck==true && pwCheck==true && pw2Check==true && nameCheck==true && emailCheck==true && phoneCheck==true ){
            frm.submit();
            }
    
    
    
            // if(u.length>3 && p.length>7 && p2.length>7 && n.length>2  && e.length>2  && ph.length>2){
            //     frm.submit();
            // }
        });
    
        uname.addEventListener("blur", function(){
    
            if(uname.value.length>1){
                unameCheck=true;
                d1.innerHTML='';
            }else {
                uname.focus();
                unameCheck=false;
                d1.innerHTML='ID는 2글자 이상이어야합니다';
            }
        
        });
    
        pw.addEventListener("change", function(){
    
            if(pw.value.length>5){
                pwCheck=true;
                d2.innerHTML='';
                pw2.value="";
            }else {
                pw.focus();
                pwCheck=false;
                d2.innerHTML='pw는 6글자 이상이어야합니다';
            }
    
        });
    
        pw2.addEventListener("blur", function(){
    
            if(pw.value==pw2.value){
                pw2Check=true;
                d3.innerHTML='';
            }else {
                pw2.focus();
                pw2Check=false;
                d3.innerHTML='비밀번호가 불일치합니다';
                pw2.value='';
            }
        
        });
    
        name.addEventListener("blur", function(){
    
            if(name.value.length>0){
                nameCheck=true;
                d4.innerHTML='';
            }else {
                name.focus();
                nameCheck=false;
                d4.innerHTML='이름은 1글자 이상이어야합니다';
            }
        
        });
    
    
        email.addEventListener("blur", function(){
    
            if(email.value.length>0){
                emailCheck=true;
                d5.innerHTML='';
            }else {
                email.focus();
                emailCheck=false;
                d5.innerHTML='이메일은 1글자 이상이어야합니다';
            }
        
        });
    
        phone.addEventListener("blur", function(){
    
            if(phone.value.length>0){
                phoneCheck=true;
                d6.innerHTML='';
            }else {
                phone.focus();
                phoneCheck=false;
                d6.innerHTML='번호는 1글자 이상이어야합니다';
            }
        
        });
    
    
    
        
    
    
    
    
    
    }