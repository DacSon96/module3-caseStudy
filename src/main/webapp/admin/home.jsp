<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
      .form-control {
        width: 400px;
        box-shadow: 0px 8px 9px 0px rgba(69, 69, 69, 0.25);
      }

      .container {
        padding-left: 300px;
        padding-top: 100px;
      }

      h2 {
        padding-left: 30px;
        color: chocolate;
      }

      .btn {
        margin-left: 150px;
        background-color: green;
      }

      .form-group {
        color: chocolate;
      }

      .checkbox {
        color: chocolate;
      }
    </style>
</head>
<script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script type="text/javascript"
        src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
<body>

<div class="container">
    <h2>Add Coach And UserCoach</h2>
    <form method="post" id="loginForm" action="/registration">
        <div class="form-group">
            <label for="fullname">FullName:</label>
            <input type="text" class="form-control" id="fullname" placeholder="Enter Fullname"
                   name="fullname">
        </div>
        <div class="form-group">
            <label for="age">Age</label>
            <input type="text" class="form-control" id="age" placeholder="Enter Age"
                   name="address">
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="text" class="form-control" id="phone" placeholder="Enter Phone"
                   name="salary">
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" placeholder="Enter Address"
                   name="bornYear">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" placeholder="Enter Email"
                   name="email">
        </div>
        <div class="form-group">
            <label for="username">User Name:</label>
            <input type="email" class="form-control" id="username" placeholder="Enter User Name"
                   name="email">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter Password"
                   name="password">
            <br>${message}
        </div>
        <div class="form-group">
            <label for="week">Role</label>
            <select id="week" name="role">
                <option value="admin">Admin</option>
                <option value="customer">Customer</option>
            </select>
        </div>
        <button type="Add" class="btn btn-default">Submit</button>
    </form>
</div>
<script type="text/javascript">
  $(document).ready(function () {
    $("#loginForm").validate({
      rules: {
        email: {
          required: true
        },
        password: {
          required: true,
          minlength: 6
        }
      },
      messages: {
        email: {
          required: "The email is required!",
        },
        password: {
          required: "Please provide a password",
          minlength: "Your password must be at least 6 characters long"
        },
      }
    });
  });
</script>


</body>
</html>