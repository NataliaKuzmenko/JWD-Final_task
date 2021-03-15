CREATE TABLE `user_roles`
(
    `role_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `role` VARCHAR(255) NOT NULL,
    CONSTRAINT `PK_user_roles` PRIMARY KEY (`role_id` ASC)
)

;
INSERT INTO user_roles (role_id, role)
VALUES (1, 'STUDENT');
INSERT INTO user_roles (role_id, role)
VALUES (2, 'LECTURER');
INSERT INTO user_roles (role_id, role)
VALUES (3, 'ADMIN');

CREATE TABLE `users`
(
    `user_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `login` VARCHAR(255) NULL,
    `password` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `first_name` VARCHAR(255) NULL,
    `last_name` VARCHAR(255) NULL,
    `role_id` INT UNSIGNED default '1' NULL,
    `photo_path` VARCHAR(255) default 'defaultPhoto.PNG' NULL,
    CONSTRAINT `PK_users` PRIMARY KEY (`user_id` ASC)
)

;
CREATE TABLE `courses`
(
    `course_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `course_title` VARCHAR(500) NOT NULL,
    `description` LONGTEXT NOT NULL,
    `materials_path` VARCHAR(255) NULL,
    `author_id` INT UNSIGNED NULL,
    CONSTRAINT `PK_courses` PRIMARY KEY (`course_id` ASC)
)

;
ALTER TABLE `courses`
    ADD INDEX `IXFK_courses_users` (`author_id` ASC)
;
ALTER TABLE `users`
    ADD CONSTRAINT `UNQ_email` UNIQUE (`email` ASC)
;
ALTER TABLE `users`
    ADD INDEX `IXFK_users_user_roles` (`role_id` ASC)
;
ALTER TABLE `courses`
    ADD CONSTRAINT `FK_courses_users`
        FOREIGN KEY (`author_id`) REFERENCES `users` (`user_id`) ON DELETE Restrict ON UPDATE Restrict
;
ALTER TABLE `users`
    ADD CONSTRAINT `FK_users_user_roles`
        FOREIGN KEY (`role_id`) REFERENCES `user_roles` (`role_id`) ON DELETE Restrict ON UPDATE Restrict
;

SET FOREIGN_KEY_CHECKS=1
;