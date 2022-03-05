  //show image after get file
  $('#photo').change(function(e){
    var reader = new FileReader();
    reader.onload = function(e){
        $("#productPhoto").attr('src',e.target.result);
        }
        reader.readAsDataURL(e.target.files['0']);
})