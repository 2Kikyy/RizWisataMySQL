<?php
include_once 'db-connect.php';

class User {
    private $db;
    private $db_table = "users";

    public function __construct() {
        $this->db = new DbConnect();
    }

    public function isLoginExist($username, $password) {
        $query = "SELECT * FROM ".$this->db_table." WHERE name = '$username' AND password = '$password' Limit 1";

        $result = mysqli_query($this->db->getDb(), $query);

        if(mysqli_num_rows($result) > 0) {
            mysqli_close($this->db->getDb());
            
            return true;
        }

        mysqli_close($this->db->getDb());
        return false;
    }

    public function isRoleUsernameExist($username, $role) {
        $query = "SELECT * FROM ".$this->db_table." WHERE name = '$username' AND role = '$role'";

        $result = mysqli_query($this->db->getDb(), $query);

        if(mysqli_num_rows($result) > 0) {
            mysqli_close($this->db->getDb());
            
            return true;
        }

        return false;
    }

    public function createNewRegisterUser($username, $password, $role) {
        $isExisting = $this->isRoleUsernameExist($username, $role);

        if($isExisting) {
            $json['success'] = 0;
            $json['message'] = "Error in registering. Probably the username/email already exists.";
        } else {
            $query = "INSERT INTO ".$this->db_table." (name, password, role) VALUES ('$username', '$password', '$role')";

            $inserted = mysqli_query($this->db->getDb(), $query);

            if($inserted == 1) {
                $json['success'] = 1;
                $json['message'] = "Successfully registered the user";
            } else {
                $json['success'] = 0;
                $json['message'] = "Error in registering. Probably the username/password already exists";
            }

            mysqli_close($this->db->getDb());
        }
        
        return $json;
    }

    public function loginUsers($username, $password) {
        $json = array();

        $canUserLogin = $this->isLoginExist($username, $password);

        if($canUserLogin) {
            $json['success'] = 1;
            $json['message'] = "Successfully logged in";
        } else {
            $json['success'] = 0;
            $json['message'] = "Incorrect details";
        }

        return $json;
    }
}
?>