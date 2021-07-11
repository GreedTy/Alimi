$(document).ready(function () {
})
function userLogout() {
    $.ajax({
        url: '/logout',
        type: 'post',
        success: function(data) {
            window.location.replace("http://localhost:8080/login")
        },
        error: function(data) {
            alert("server error");
        }
    })
}

function createStudyGroup() {
    let studyGroupName = $('input[name=studyGroupName]').val();
    let studyGroupMaster = $('input[name=studyGroupMaster]').val();
    let studyGroupCategory = $('input[name=studyGroupCategory]').val();
    $.ajax({
        url: '/group',
        type: 'post',
        contentType: 'application/json',
        data: JSON.stringify({
            'name': studyGroupName,
            'master': studyGroupMaster,
            'category': studyGroupCategory
        }),
        success: function(data) {
            $("#createStudyGroupModal").modal('hide')
            firstGroupList()
        },
        error: function (data) {
            alert("그룹생성 실패 관리자에게 문의해주세요")
        }
    })
}

function deleteStudyGroup(id) {
    $.ajax({
        url:'/group/' + id,
        type: 'post',
        contentType: 'application/json',
        success: function (data) {
            alert("삭제성공")
        },
        error: function (data) {
            alert("삭제실패")
        }
    })
}

function firstGroupList() {
    $.ajax({
        url: '/group',
        type: 'get',
        success: function (data) {

        },
        error: function (data) {
            // grouplist list 못 가져옴
            alert("그룹리스트를 불러올 수 없습니다. 관리자에게 문의하세요.")
        }
    })
}

function groupList(pageNum= 1) {
    console.log(pageNum)
    $.ajax({
        url: '/group/list',
        type: 'get',
        data: {"page": pageNum},
        success: function (data) {
            alert("test");
            /*console.log(data['studyGroupList']);
            console.log(data['startPage']);
            console.log(data['endPage'])
            let innerHtml = '';
            $.each(data['studyGroupList'], function (index, value) {
                innerHtml += '<tr>'
                innerHtml +=    '<td><img src="https://bootdey.com/img/Content/avatar/avatar1.png" width="32" height="32" class="rounded-circle my-n1" alt="Avatar"></td>'
                innerHtml +=    '<td></td>'
                innerHtml +=    '<td>' + data['studyGroupList'][index].name + '</td>'
                innerHtml +=    '<td>' + data['studyGroupList'][index].master + '</td>'
                innerHtml +=    '<td></td>'
                innerHtml +=    '<td><span class="badge bg-success">모집중</span></td>'
                innerHtml +=    '<td><button onclick="deleteStudyGroup( + data[\'studyGroupList\'][index].value() + );">삭제</button></td>'
                innerHtml += '</tr>'
            })
            $("#listContainer").html(innerHtml);
            innerHtml = '';
            $.each(data['pageList'], function (index, value) {
                innerHtml += '<li class="page-item" style="display:inline-block">'
                innerHtml += '<span class="page-link" onclick="groupList( + data[\'pageList\'][index].value() + );">' + data['pageList'][index].number + '</span>'
                innerHtml += '</li>'
            })
            $("#pageContainer").html(innerHtml)*/
        },
        error: function (data) {
            // grouplist list 못 가져옴
            alert("그룹리스트를 불러올 수 없습니다. 관리자에게 문의하세요.")
        }
    })
}