const btn = document.querySelector("#btn");
const contents = document.querySelector("#contents");
const writer = document.querySelector("#writer");
const commentList = document.querySelector("#commentList");

getCommentList();

btn.addEventListener("click", function(){
    let bookNum = btn.getAttribute("data-bookNum");
    let wv = writer.value;
    let cv = contents.value;

    //--ajax------
    //1.XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2.메서드, url준비
    // 요청을 보낼 주소 작성
    xhttp.open("POST", "./commentAdd");
  
    //3.enctype
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //4.요청 발생, 전송(post일 경우 파라미터를 추가)
    xhttp.send("bookNum="+bookNum+"&writer="+wv+"&contents="+cv);

    //5.응답 처리
    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
            let result=xhttp.responseText.trim();
            // 응답은 responsText에 담김
            console.log(result);
            result = JSON.parse(result);
            if(result.result==1){
                alert("댓글 등록 성공");
                getCommentList();
            }else{
                alert("댓글 등록 실패");
            }
        
        }
    } 

})

function getCommentList(){
    //1. XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. Method, URL
    xhttp.open("GET", "./commentList?page=1&bookNum=" + btn.getAttribute("data-bookNum")); //detail.jsp에서 bookNum을 받아오는게 data-bookNum이기때문에 속성을 받아오면 댓글작성한 bookNum의 댓글표가 아래 나옴

    //3. 요청 전송
    xhttp.send();

    //4. 응답 처리
    xhttp.addEventListener("readystatechange" , function(){
        if(xhttp.readyState == 4 && xhttp.status == 200){
            console.log(xhttp.responseText);

            //1. jsp 사용한 결과물
            commentList.innerHTML = xhttp.responseText;

            //2. JSON 결과물
        }
    });
}