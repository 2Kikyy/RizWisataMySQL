<?php

require_once 'user.php';

$username = "";
$password = "";
$role = "";

if(isset($_POST['name'])) {
    $username = $_POST['username'];
}

if(isset($_POST['password'])) {
    $password = $_POST['password'];
}

if(isset($_POST['role'])) {
    $role = $_POST['role'];
}

$userObject = new User();

// Registration
if(!empty($username) && !empty($password) && !empty($role)) {
    $hashed_password = md5($password);
    $json_array = $userObject->loginUsers($username, $hashed_password);
    echo json_encode($json_array);
}
?>