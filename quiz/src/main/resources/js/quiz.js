let questions;
$(document).ready(function () {
    $.ajax({
        url: "/api/quiz",
        method: "GET",
        success: function (quizs) {


            let html = ``;
            quizs.forEach((quiz) => {
                html += `<button onclick="showQuestion(${quiz.id})">${quiz.quizName}</button>`
            })
            document.getElementById("listQuiz").innerHTML = html
        },
        error: function () {
            console.log("Lỗi lưu lịch sử tinh nhắn ");
        }
    });
})
function showQuestion(id) {
    const listQuiz = document.getElementById("listQuiz");

    listQuiz.style.display = "none";
    // summitCoure.style.display = "flex";

    console.log(id)
    $.ajax({
        url: "/api/question/findAll",
        method: "GET",
        data: {
            id: id
        },

        success: function (data) {
            questions = data;

            let html = ``;
            let htmlChoose = ``;
            data.forEach((question, index) => {

                let htmlAnswer = ``;
                console.log(question)

                question.answers.forEach((answer) => {
                    if (question.type === "radio"){

                        htmlAnswer += `
                         
                        <div class="ans ml-2">
                              <label class="radio"> <input type="radio" name="quet-${question.id}" value="${answer.title}" onclick="onChoose(${index})"> <span>${answer.title}</span>
                              </label>
                        </div>
                        
                    `
                    }else {
                        htmlAnswer += `
                          
                        <div class="ans ml-2">
                              <label class="radio2"> <input type="checkbox" name="quet-${question.id}" onclick="onChoose(${index})" value="${answer.title}"> <span>${answer.title}</span>
                              </label>
                        </div>
                       
                    `
                    }

                })

                html += `<div style="display: none" id="question-${index}">
                        <div class="question bg-white p-3 border-bottom">
                          <div class="d-flex flex-row justify-content-between align-items-center mcq">
                              <h4>MCQ Quiz</h4><span>(${index + 1} of ${questions.length})</span></div>
                      </div>
                      <div class="question bg-white p-3 border-bottom">
                          <div class="d-flex flex-row align-items-center question-title">
                              <h3 class="text-danger">Q.</h3>
                              <h5 class="mt-1 ml-2" >${question.title}</h5>

                          </div>

                          ${htmlAnswer}
                      </div>
                      
                      
                      <div class="d-flex flex-row justify-content-between align-items-center p-3 bg-white">
                        <button class="btn btn-primary d-flex align-items-center btn-danger" type="button" onclick="prev(${index})" ${index === 0 ? 'disabled' : ''}><i class="fa fa-angle-left mt-1 mr-1"></i>&nbsp;previous</button>
                        <button class="btn btn-primary border-success align-items-center btn-success" type="button" onclick="next(${index})" ${index === questions.length - 1 ? 'disabled' : ''}>Next<i class="fa fa-angle-right ml-2"></i></button>
                      </div>
                      </div>
                     
                    `
                htmlChoose += `
                            <div class="number-buttons"  >
                            
                                  <button id="number-question-${index}" style="border: 1px solid black"  onclick="choose(${index})" >${index + 1}</button>
                                 
                            </div>
                    `


            })

            document.getElementById("htmlChoose").innerHTML = htmlChoose
            document.getElementById("mainQuestion").innerHTML = html
            document.getElementById("question-0").style.display = "block"
        },
        error: function () {
            console.log("Lỗi khi lấy lịch sử tin nhắn");
        }
    });

}
// function onChoose(index){
//     const inputCheck = document.getElementsByName(`quet-${questions[index].id}`);
//     for (let i = 0; i < inputCheck.length; i++) {
//         if(inputCheck[i].checked){
//             document.getElementById(`number-question-${index}`).style.background = 'red';
//         }else {
//             document.getElementById(`number-question-${index}`).style.background = 'none';
//         }
//     }
// }
function onChoose(index){
    const inputCheck = document.getElementsByName(`quet-${questions[index].id}`);
    let hasChecked = false;

    for (let i = 0; i < inputCheck.length; i++) {
        if(inputCheck[i].checked){
            hasChecked = true;
            break; // Nếu đã tìm thấy ít nhất một lựa chọn được chọn, thoát vòng lặp
        }
    }

    // Đặt màu nền cho nút chọn số tương ứng dựa trên trạng thái lựa chọn
    const numberButton = document.getElementById(`number-question-${index}`);
    if (hasChecked) {
        numberButton.style.background = 'red';
    } else {
        numberButton.style.background = 'none';
    }
}
// function choose(index){
//     document.getElementById("question-"+index).style.display = "block";
//     console.log(index)
// }
function choose(index){
    // Ẩn tất cả các câu hỏi
    for (let i = 0; i < questions.length; i++) {
        document.getElementById("question-" + i).style.display = "none";
    }

    // Hiển thị câu hỏi tương ứng với số được chọn
    document.getElementById("question-" + index).style.display = "block";
    console.log(index);
}
function prev(index){
    let next = index-1;
    const summitCoure = document.getElementById("summit-coure");
    summitCoure.style.display = "none";
    document.getElementById("question-"+index).style.display = "none"

    document.getElementById("question-"+next).style.display = "block"
}

function next(index){
    let next = index+1;
    const summitCoure = document.getElementById("summit-coure");

    document.getElementById("question-"+index).style.display = "none"

    document.getElementById("question-"+next).style.display = "block"

    if (index === questions.length - 2){
        summitCoure.style.display = "flex";
    }
}
function submit(){
    let values = [];
    let isFull = true;
    for (let i = 1; i <= questions.length; i++) {
        console.log(questions.length)
        let inputName = "quet-" + i;
        let inputElement = document.querySelectorAll('input[name="' + inputName + '"]:checked');
        if(inputElement.length<=0){
            isFull=false;
            break;
        } else {
            let answerO = {};
            let checkAns= [];
            if (inputElement[0].type === "radio") {
                valueInput = inputElement[0].value;
                answerO.title = valueInput;
                answerO.type = "radio"
                values.push(answerO);
            } else  {
                // Lặp qua tất cả các checkbox đã chọn và lấy giá trị của chúng
                inputElement.forEach(function(checkbox) {
                    checkAns.push(checkbox.value);
                });
                answerO.title = checkAns;
                answerO.type = "checkbox"
                values.push(answerO);
            }
        }
    }
    if(!isFull){
        alert("nhập cho hết đê")
    } else {
        alert("bạn đã được " + checkAnswer(values) + "/" + questions.length + " điểm")
    }
    console.log(checkAnswer(values))
    console.log(values)
    console.log(questions)
}
// function checkAnswer(value){
//     console.log(questions)
//     let score = 0;
//     for (let i = 0; i < questions.length; i++) {
//         if (value[i].type === "radio") {
//             for (let j = 0; j < questions[i].answers.length; j++) {
//                 if (questions[i].answers[j].title === value[i].answer && questions[i].answers[j].status === true)
//                     score++;
//             }
//         } else if (value[i].type === "checkbox") {
//             let correctAns =[]
//             questions[i].answers.filter(ans => {
//                 if(ans.status === true){
//                     correctAns.push(ans.title)
//                 }
//             });
//             if(checkAnsCheckbox(correctAns,value[i].answer)){
//                 score++;
//             }
//         }
//     }
//     return score;
// }
function checkAnswer(value){
    let score = 0;
    console.log(value)
    for (let i = 0; i < questions.length; i++) {
        if (value[i].type === "radio") {
            for (let j = 0; j < questions[i].answers.length; j++) {
                if (questions[i].answers[j].title === value[i].title && questions[i].answers[j].status === true)
                    score++;
            }
        } else if (value[i].type === "checkbox") {
            let correctAns =[]

            questions[i].answers.filter(ans => {
                if(ans.status === true){
                    correctAns.push(ans.title)
                }
            });
            if(checkAnsCheckbox(correctAns,value[i].title)){
                score++;
            }
        }
    }
    return score;
}

function checkAnsCheckbox(array1, array2) {
    if (array1.length !== array2.length) {
        return false;
    }
    let ans = true;
    for (let i = 0; i < array1.length; i++) {
        if (array2.indexOf(array1[i]) === -1) {
            ans = false;
            break;
        }
    }
    return ans;
}


