
var Project1 = ( function() {

    return {

        init: function() { 
            
            $("#version").html( "jQuery Version: " + $().jquery );
            
        },
        
        registration: function() {
            
            var that = this;
            
            $.ajax({

                url: 'registration',
                method: 'POST',
                data: $('#registrationform').serialize(),

                success: function(response) {
                    
                    var name = $("#name").val();
                    var displayname = $("#displayname").val();
                    var email = $("#email").val();
                    
                    if( name === "" || displayname === "" || email === "" ) {
                        
                        $("#output").html("Please fill all the fields");
                        
                    }
                    else {
                        
                        $("#output").html("Dear " + name + ", Thank you for signing up!!");
                        $("#displayname").val("");
                        $("#name").val("");
                        $("#email").val("");
                        $("#comment").val("");
                        
                    }
                 
                }

            });          
        }

    };

}());


