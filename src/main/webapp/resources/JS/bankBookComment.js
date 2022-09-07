const btn = document.querySelector("#btn");
const contents = document.querySelector("#contents");
const writer = document.querySelector("#writer");
const commentList = document.querySelector("#commentList");
const plus = document.querySelector("#plus");


//page 번호 담는 변수
let page = 1;
// bookNum을 담을 변수
const bookNum = btn.getAttribute("data-bookNum");
getCommentList(page, bookNum);

btn.addEventListener("click", function(){
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

                for(let i=0; i<commentList.children.length;){
                    commentList.children[0].remove();
                }

                // if(commentList.children.length != 0){
                //     commentList.children[0].remove();
                // }
                page = 1;

                getCommentList(page, bookNum);
            }else{
                alert("댓글 등록 실패");
            }
        
        }
    } 

})

function getCommentList(p, bn){
    //1. XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. Method, URL
    // xhttp.open("GET", "./commentList?page=1&bookNum=" + btn.getAttribute("data-bookNum")); //detail.jsp에서 bookNum을 받아오는게 data-bookNum이기때문에 속성을 받아오면 댓글작성한 bookNum의 댓글표가 아래 나옴
    xhttp.open("GET", "./commentList?page=" + p + "&bookNum=" + bn);

    //3. 요청 전송
    xhttp.send();

    //4. 응답 처리
    xhttp.addEventListener("readystatechange" , function(){
        if(xhttp.readyState == 4 && xhttp.status == 200){
            console.log(xhttp.responseText);

            //1. jsp 사용한 결과물
            // commentList.innerHTML = xhttp.responseText;

            //2. JSON 결과물
            let result = JSON.parse(xhttp.responseText.trim());
        //     let result = document.createElement("table");
        //     let resultAttr = document.createAttribute("class");
        //     resultAttr.value = "table table-dark table-striped";
        //    // result.setAttributeNode(resultAttr);

            let pager = result.pager;   //commentPager
            let ar = result.list;       //댓글리스트(배열)

            for(let i=0;i<ar.length;i++){

                let tr = document.createElement("tr");  //<tr></tr>
                let td = document.createElement("td");  //<td></td>
                let tdText = document.createTextNode(ar[i].contents);
                td.appendChild(tdText);
                tr.appendChild(td);
                

                td = document.createElement("td");
                tdText = document.createTextNode(ar[i].writer);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode(ar[i].regDate);
                td.appendChild(tdText);
                tr.appendChild(td);

                
                td = document.createElement("td");
                tdText = document.createTextNode("수정");
                let tdAttr = document.createAttribute("class");
                tdAttr.value = "update";
                td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-comment-num");
                tdAttr.value = ar[i].num;
                td.setAttributeNode(tdAttr);
                td.appendChild(tdText);
                tr.appendChild(td);
    

                td = document.createElement("td");
                tdText = document.createTextNode("삭제");
                tdAttr = document.createAttribute("class");
                tdAttr.value = "delete";
                td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-comment-num");
                tdAttr.value = ar[i].num;
                td.setAttributeNode(tdAttr);
                td.appendChild(tdText);
                tr.appendChild(td);


                commentList.appendChild(tr);

                if(page >= pager.totalPage){
                    plus.classList.add("disabled");
                }else{
                    plus.classList.remove("disabled");
                }
            }

            // console.log(result);
            // console.log(commentList.children);

            // let t = commentList.children;

            // if(t.length != 0){
            //     commentList.children[0].remove();
            // }

            // try {
                //     console.log(commentList.children());
                //     throw new Error("삐빅!");
                // } catch (exception) {
                    
                    // }finally{
                        
                        // }
            // commentList.append(result);
           
        }
    });
}

//----------------------더보기----------------------

plus.addEventListener("click", function(){
    page++; //====>> page = page + 1; 
    const bookNum = btn.getAttribute("data-bookNum");
    console.log(page);
    console.log(bookNum);

    getCommentList(page, bookNum);

    
});

//------------------Update---------------

    // if(event.target.className=="update"){
    //     let check = window.confirm("수정 하고싶어??");

    //     if(check){
    //         let num = event.target.getAttribute("data-comment-num");
    //         console.log("num : ", num);

    //         //1. XMLHTTPResquest
    //         const xhttp = new XMLHttpRequest();

    //         //2. 요청정보
    //         xhttp.open("POST", "commentUpdate");

    //         //3. POST라서, Header의 정보를 줘야함 (enctype)
    //         xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //         //4. 요청 (파라미터와 함께)
    //         xhttp.send("num=" + num);

    //         //5. 응답 처리
    //         xhttp.onreadystatechange = function(){
    //             if(xhttp.readyState == 4 && xhttp.status == 200){
    //                 let result = xhttp.responseText.trim();
    //                 if(result == 1){
    //                     alert("수정 성공!!");
    //                     page = 1;
    //                     for(let i=0; i<commentList.children.length;){
    //                         commentList.children[0].remove();
    //                     }

    //                     getCommentList(page, bookNum);
    //                 }else{
    //                     alert("수정 실패!!");
    //                 }
    //             }
    //         }
    //     }
    // }


commentList.addEventListener("click", function(event){

    //------------------Update---------------

    if(event.target.className == "update"){
        let check = window.confirm("수정 하고싶어??");

        // let contents = event.target.previousSibling.previousSibling.previousSibling;
        // console.log(contents);
        // let v = contents.innerHTML;
        // contents.innerHTML = "<textarea>"+v+"</textarea>";

        document.getElementById("up").click();   //수정 영역을 클릭하면 강제로 up 버튼이벤트를 발생시킴

        
    }


    //-----------------Delete---------------
    if(event.target.className == "delete"){
        let check = window.confirm("이걸 누르면 돌이킬 수 없습니다(삭제)");

        if(check){
            let num = event.target.getAttribute("data-comment-num");
            console.log("Num : ", num);

            //1. XMLHTTPResquest
            const xhttp = new XMLHttpRequest();

            //2. 요청정보(URL, Method)
            xhttp.open("POST", "commentDelete");

            //3. POST이기 떄문에 Header정보를 넣어줘야함 (enctype)
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            //4. 요청 (파라미터와 함께)
            xhttp.send("num=" + num); //"num=" ""사이에 띄어쓰기 하면 오류뜸 하지말기!

            //5. 응답처리
            xhttp.onreadystatechange = function(){
                if(xhttp.readyState == 4 && xhttp.status == 200){
                    let result = xhttp.responseText.trim();
                    console.log(result);
                    if(result == 1){
                        alert("삭제 성공");
                        page = 1;
                        for(let i=0; i<commentList.children.length;){
                            commentList.children[0].remove();
                        }
        
                        getCommentList(page, bookNum);
                    }else{
                        alert("삭제 실패");
                    }
                }
            }
        }
    }


});