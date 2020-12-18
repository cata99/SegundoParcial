INSERT INTO `USER` (`ID`, `EMAIL`, `LASTNAME`, `NAME`) VALUES ('1', 'martincacres@gmail.com', 'caceres', 'martin');
INSERT INTO `USER` (`ID`, `EMAIL`, `LASTNAME`, `NAME`) VALUES ('2', 'catalinapaschini@gmail.com', 'paschini ', 'catalina');
INSERT INTO `USER` (`ID`, `EMAIL`, `LASTNAME`, `NAME`) VALUES ('3', 'menelangelo@gmail.com', 'menel ', 'angelo');

INSERT INTO `PROYECT` (`ID`, `DESCRPTION`, `NAME`, `START_DATE`, `STATE_PROYECT`) VALUES ('1', 'This project is about this', 'Project_1', '2020-04-19 03:55:03', '1');
INSERT INTO `PROYECT` (`ID`, `DESCRPTION`, `NAME`, `START_DATE`, `STATE_PROYECT`) VALUES ('2', 'This project is about that', 'Project_2', '2019-11-03 12:55:03', '2');

INSERT INTO `PROYECT_USER` (`Proyect_ID`, `users_ID`) VALUES ('1', '1');
INSERT INTO `PROYECT_USER` (`Proyect_ID`, `users_ID`) VALUES ('1', '2');
INSERT INTO `PROYECT_USER` (`Proyect_ID`, `users_ID`) VALUES ('1', '3');
INSERT INTO `PROYECT_USER` (`Proyect_ID`, `users_ID`) VALUES ('2', '1');
INSERT INTO `PROYECT_USER` (`Proyect_ID`, `users_ID`) VALUES ('2', '2');

INSERT INTO `STATE` (`ID`, `STATE`) VALUES ('1', 'Stand-by');
INSERT INTO `STATE` (`ID`, `STATE`) VALUES ('2', 'Done');
INSERT INTO `STATE` (`ID`, `STATE`) VALUES ('3', 'Canceled');
INSERT INTO `STATE` (`ID`, `STATE`) VALUES ('4', 'Opened');
INSERT INTO `STATE` (`ID`, `STATE`) VALUES ('5', 'Re-opened');

INSERT INTO `TASK` (`ID`, `DESCRIPCION`, `NAME`, `PROYECT_ID`, `STATE_ID`) VALUES ('1', 'Do this', 'Task_1', '2', '1');
INSERT INTO `TASK` (`ID`, `DESCRIPCION`, `NAME`, `PROYECT_ID`, `STATE_ID`) VALUES ('2', 'Do that', 'Task_2', '1', '3');
INSERT INTO `TASK` (`ID`, `DESCRIPCION`, `NAME`, `PROYECT_ID`, `STATE_ID`) VALUES ('3', 'Do this 2', 'Task_3', '1', '4');
INSERT INTO `TASK` (`ID`, `DESCRIPCION`, `NAME`, `PROYECT_ID`, `STATE_ID`) VALUES ('4', 'Do that 2', 'Task_4', '1', '5');

INSERT INTO `ticket`.`COMMENT` (`ID`, `DESCRIPTION`, `TASK_ID`, `USER_ID`) VALUES ('1', 'Nice task', '1', '1');
INSERT INTO `ticket`.`COMMENT` (`ID`, `DESCRIPTION`, `TASK_ID`, `USER_ID`) VALUES ('2', 'Bad Task', '2', '2');
INSERT INTO `ticket`.`COMMENT` (`ID`, `DESCRIPTION`, `TASK_ID`, `USER_ID`) VALUES ('3', 'I dont want to to this', '1', '1');



