//ajax_1.js

const d1 = document.querySelector("#d1");
const t1 = document.querySelector("#t1");
const result = document.querySelector("#result");

d1.addEventListener("click", function(){
    console.log("click");
    let t = t1.value;

    //1. ajax로 요청하는 객체 생성
    let xhttp = new XMLHttpRequest();

    //2. 요청 정보
    xhttp.open("GET", "https://jsonplaceholder.typicode.com/posts/"+t);

    //3. 요청 발생
    xhttp.send();

    //4. 응답 결과 처리
    xhttp.onreadystatechange = function(){
        //this는 http 객체
        // console.log(this.status);
        // console.log(this.readyState);
        // console.log("====================================");
        if(this.readyState==4 && this.status==200){

            // console.log(this.responseText);
            let response = this.responseText.trim();
            response = JSON.parse(response);
            
            console.log(response.userId);
            console.log(response.id);
            console.log(response.title);
            console.log(response.body);

            let h3 = document.createElement("h3");
            let h3Text = document.createTextNode(response.userId);
            h3.appendChild(h3Text);
            result.append(h3);
            console.log(h3);

            h3 = document.createElement("h3");
            h3Text = document.createTextNode(response.id);
            h3.appendChild(h3Text);
            result.append(h3);
         
            h3 = document.createElement("h3");
            h3Text = document.createTextNode(response.title);
            h3.appendChild(h3Text);
            result.append(h3);

            h3 = document.createElement("h3");
            h3Text = document.createTextNode(response.body);
            h3.appendChild(h3Text);
            result.append(h3);

        }
    }



    console.log("Ajax 발생");
});