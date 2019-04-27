
/*drozone上传图片*/
function  DropzoneUpload(id,valueId) {

    Dropzone.autoDiscover = false;//防止报"Dropzone already attached."的错误
    $(id).dropzone({
        url:"/upload",
        paramName:"dropFile",
        maxFiles: 10, // 一次性上传的文件数量上限
        maxFilesize: 2, // 文件大小，单位：MB
        acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
        addRemoveLinks: true,
        parallelUploads: 2, // 一次上传的文件数量
        dictDefaultMessage: '拖动文件至此或者点击上传',
        dictMaxFilesExceeded: "您最多只能上传 1 个文件！",
        dictResponseError: '文件上传失败!',
        dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg",
        dictFallbackMessage: "浏览器不受支持",
        dictFileTooBig: "文件过大上传文件最大支持",
        dictRemoveLinks: "删除",
        dictCancelUpload: "取消",
        init:function () {
            this.on("success",function (file,res) {

                $(valueId).val(res.fileName);

            });

            this.on("queuecomplete",function(file) {
            });
            this.on("removedfile",function(file){
                //删除文件时触发的方法
                $(valueId).val(null);
            });



        }
    });

}


/*wangeditor上传图片*/
function wanditorUpload(valueid) {

    var E = window.wangEditor;
    var editor = new E('#editor');
    // 配置服务器端地址
    editor.customConfig.uploadImgServer = '/upload';
    editor.customConfig.uploadFileName = 'editorFiles';
    editor.create();

    $("#btnSubmit").bind("click", function() {
        var contentHtml = editor.txt.html();

        $(valueid).val(contentHtml);
    });

}

function fileUpload(id,inputid,url){

    var formData = new FormData();
    formData.append('file', $(id)[0].files[0]);
    $.ajax({
        url: url,
        type: 'POST',
        cache: false,
        data: formData,
        processData: false,
        contentType: false
    }).done(function(res) {
        confirm("文件上传成功！");
        $(inputid).val(res);



    }).fail(function(res) {
        confirm("文件上传失败！");
    });

}




function onSubmit(){
    在js中判断文件上传类型
    var form1 = document.forms[0];
    var file = document.forms[0].getfile.value;
    if (file == null||file == ""){
        alert("请选择要上传的图片!");
        return false;
    }
    if (file.lastIndexOf('.')==-1){    //如果不存在"."
        alert("路径不正确!");
        return false;
    }
    var AllImgExt=".jpg|.jpeg|.gif|.bmp|.png|";
    var extName = file.substring(file.lastIndexOf(".")).toLowerCase();//（把路径中的所有字母全部转换为小写）
    if(AllImgExt.indexOf(extName+"|")==-1)
    {
        ErrMsg="该文件类型不允许上传。请上传 "+AllImgExt+" 类型的文件，当前文件类型为"+extName;
        alert(ErrMsg);
        return false;
    }
    document.forms[0].submit();
}
