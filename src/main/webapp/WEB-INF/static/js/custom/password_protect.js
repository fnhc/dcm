$(function(){
    $(document).on("paste contextmenu copy cut", "input[type='password']", function(){return false;});
    $(document).on("keydown", "input[type='password']", function(e){if (e.keyCode == 222 || e.keyCode == 32 || e.keyCode == 220) return false;});
});

