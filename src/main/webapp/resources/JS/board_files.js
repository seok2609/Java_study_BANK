//board_files.js
const fileAdd = document.getElementById("fileAdd"); //add button
const addFiles = document.getElementById("addFiles"); // div#addFiles
const fileDelete = document.querySelectorAll(".fileDelete"); //forEach 가능
// const fileDelete = document.getElementsByClassName("fileDelete");   //forEach 불가능


//------------------------Notice Update 시 file Delete-----------------------
try{
fileDelete.forEach(function(f){
    console.log(f);
    f.addEventListener("click", function(){

        console.log(f.parentNode);
 
        let check = window.confirm("삭제를 하면 되돌릴 수 없습니다");

        if(!check){
            return;
        }

        let fileNum = f.getAttribute("data-file-num");

        //ajax
        const xhttp = new XMLHttpRequest();

        xhttp.open("POST", "./fileDelete");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xhttp.send("fileNum="+fileNum);


        xhttp.onreadystatechange = function(){
            if(xhttp.readyState == 4 && xhttp.status == 200){
                let result = xhttp.responseText.trim();
                if(result == 1){
                    alert("삭제 성공");
                    f.parentNode.remove();
                    count--;
                }else{
                    alert("삭제 실패");
                }
            }
        }
    });
});
}catch(e){
    console.log(e);
}

// for(fi of fileDelete){
//     console.log(fi);
// }

//---------------------------Notice Add시 file Add -------------------------
let idx = 0;
let count = 0;

function setCount(c){
    if(c >= 0){
        count = c;
    }
}

try{
fileAdd.addEventListener("click", function(){

    

    
    if(count>4){
        alert("최대 5번만 가능");
        return;
    }

    //  <div class="mb-3">
    //     <label for="file" class="form-label">File</label>
    //     <input type="file" name="files" class="form-control" id="file">
    //     <button type="button" class="del">삭제</button>
    //   </div>


    //부모 Element div 생성
    let div = document.createElement("div"); //<div></div>
    let c = document.createAttribute("class"); //class=""
    c.value = "mb-3";                           //class="mb-3"
    div.setAttributeNode(c);                    //<div class="mb-3" </div>
    c = document.createAttribute("id");
    c.value="file"+idx;
    div.setAttributeNode(c);


    //자식 Element Label 생성
    let label = document.createElement("label"); //<label></label>
    let labelText = document.createTextNode("File"); //      "File"
    label.appendChild(labelText);               // <label>File</label>
    let labelClass = document.createAttribute("class"); // class=""
    labelClass.value = "form-label";                //class="form-label"
    label.setAttributeNode(labelClass);             //<label class="form-label" </label>
    labelClass = document.createAttribute("for");   //for="";
    labelClass.value = "files";                     //for = "files"
    label.setAttributeNode(labelClass);             //<label for="files" class="form-label" </label>

    div.appendChild(label);

    //자식 Element Input 생성
    let input = document.createElement("input");    //<input>
    let inputAttr = document.createAttribute("type");   //type=""
    inputAttr.value = "file";                           //type="file"
    input.setAttributeNode(inputAttr);              //<input type = "file"

    inputAttr = document.createAttribute("name");   //name=""
    inputAttr.value = "files";                       //name ="files"       
    input.setAttributeNode(inputAttr);               //<input type="file" name="files"

    inputAttr = document.createAttribute("class");      //class=""
    inputAttr.value = "form-control";                   //class="form-control"
    input.setAttributeNode(inputAttr);                   //<input type="file" name="files" class="form-control"

    inputAttr = document.createAttribute("id");           //id=""
    inputAttr.value = "file";                            //id="file"          
    input.setAttributeNode(inputAttr);                       //<input type = "file" name = "files" class="form-control" id="file"

    div.appendChild(input);


    //자식 Element 삭제 button 생성
    let button = document.createElement("button");      //<button>
    let buttonContents = document.createTextNode("삭제"); //"삭제"
    button.appendChild(buttonContents);                 //<button>삭제</button>
    let buttonAttr = document.createAttribute("type");  //type=""
    buttonAttr.value="button";                          //type="button"
    button.setAttributeNode(buttonAttr);                //<button type = "button"

    buttonAttr = document.createAttribute("class");     //class=""
    buttonAttr.value = "del btn btn-danger";                           //class="del"
    button.setAttributeNode(buttonAttr);                    //<button type="button" class="del"

    buttonAttr = document.createAttribute("title");
    buttonAttr.value=idx;
    button.setAttributeNode(buttonAttr);

    div.appendChild(button);

    
    addFiles.append(div);
    
    count ++;
    idx++;
})

//Element button 삭제이벤트 만들기
addFiles.addEventListener("click", function(event){
    let button = event.target;
    if(event.target.classList[0]=='del'){
        alert(button.title);
        document.getElementById("file" + button.title).remove();
        count--;                                                    // count--;를 써서 파일삭제후 다시 파일추가를 눌러도 5개까지 생성되게 만듬

    }
});

}catch(e){

}