   //sweet alert for delete
   $(function() {
    $(document).on('click', '#delete', function(e) {
        e.preventDefault();
        var link = $(this).attr("href");
        console.log(link);

        Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                window.location.href = link
                Swal.fire(
                    'Deleted!',
                    'Your data has been deleted.',
                    'success'
                )
                Swal.close()
            }
        })
    })
})

//    //sweet alert for logout
   $(function() {
    $(document).on('click', '#logout', function(e) {
        e.preventDefault();
        var link = $(this).attr("href");
        console.log(link);

        Swal.fire({
            title: 'Are you sure want to logout?',
            text: "You will be returned to login screen",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Logout'
        }).then((result) => {
            if (result.isConfirmed) {
                window.location.href = '/logout'
                Swal.fire(
                    'Logged out!',
                    'You have been logged out.',
                    'success'
                )
                Swal.close()
            }
        })
    })
})