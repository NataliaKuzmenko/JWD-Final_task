SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE `users`
(
    `user_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `login` VARCHAR(255) NULL,
    `password` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `first_name` VARCHAR(255) NULL,
    `last_name` VARCHAR(255) NULL,
    `role_id` ENUM('STUDENT', 'LECTURER', 'ADMIN') default 'STUDENT' NOT NULL,
    `photo_path` VARCHAR(255) default 'defaultPhoto.png' NULL,
    CONSTRAINT `PK_users` PRIMARY KEY (`user_id` ASC)
)

;
CREATE TABLE `courses`
(
    `course_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `course_title` VARCHAR(500) NOT NULL,
    `description` LONGTEXT NOT NULL,
    `materials_path` VARCHAR(255) NULL,
    `author_id` BIGINT UNSIGNED NULL,
    CONSTRAINT `PK_courses` PRIMARY KEY (`course_id` ASC)
)

;
CREATE TABLE `course_run`
(
    `course_run_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `course_id` BIGINT UNSIGNED NULL,
    `start_course` TIMESTAMP(1) NULL,
    `end_course` TIMESTAMP(1) NULL,
    `lecturer_id` BIGINT UNSIGNED NULL,
    `format` ENUM('ONLINE', 'OFFLINE') NOT NULL,
    `status` ENUM('NOT_STARTED', 'IN_PROGRESS', 'FINISHED') default 'NOT_STARTED' NOT NULL,
    `limit_students` INT default '12' NULL,
    CONSTRAINT `PK_course_run` PRIMARY KEY (`course_run_id` ASC)
)

;
CREATE TABLE `lists_students`
(
    `result_course_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `user_id` BIGINT UNSIGNED NOT NULL,
    `course_run_id` BIGINT UNSIGNED NOT NULL,
    `status_student_id` ENUM('APPLIED', 'TRAINING_IN_PROGRESS', 'FINISHED', 'DENIED') default 'APPLIED' NOT NULL,
    `mark` INT UNSIGNED NULL,
    `comment` LONGTEXT NULL,
    CONSTRAINT `PK_lists_students` PRIMARY KEY (`result_course_id` ASC)
)

;
ALTER TABLE `courses`
    ADD INDEX `IXFK_courses_users` (`author_id` ASC)
;
ALTER TABLE `users`
    ADD CONSTRAINT `UNQ_email` UNIQUE (`email` ASC)
;

ALTER TABLE `courses`
    ADD CONSTRAINT `FK_courses_users`
        FOREIGN KEY (`author_id`) REFERENCES `users` (`user_id`) ON DELETE Restrict ON UPDATE Restrict
;
ALTER TABLE `course_run`
    ADD INDEX `IXFK_course_run_courses` (`course_id` ASC)
;

ALTER TABLE `course_run`
    ADD INDEX `IXFK_course_run_users` (`lecturer_id` ASC)
;

ALTER TABLE `course_run`
    ADD CONSTRAINT `FK_course_run_users`
        FOREIGN KEY (`lecturer_id`) REFERENCES `users` (`user_id`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `lists_students`
    ADD INDEX `IXFK_lists_students_course_run` (`course_run_id` ASC)
;

ALTER TABLE `lists_students`
    ADD INDEX `IXFK_lists_students_users` (`user_id` ASC)
;

ALTER TABLE `lists_students`
    ADD CONSTRAINT `FK_lists_students_users`
        FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE Restrict ON UPDATE Restrict
;
SET FOREIGN_KEY_CHECKS=1
;