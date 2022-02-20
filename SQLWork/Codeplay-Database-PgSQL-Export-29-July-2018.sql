-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               PostgreSQL 10.4, compiled by Visual C++ build 1800, 64-bit
-- Server OS:                    
-- HeidiSQL Version:             9.3.0.5119
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES  */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for public
CREATE DATABASE IF NOT EXISTS "public";
USE "public";

-- Dumping structure for table public.auto_sequence
CREATE TABLE IF NOT EXISTS "auto_sequence" (
	"sequence_name" CHARACTER VARYING(255) NOT NULL COMMENT E'',
	"init_val" BIGINT NOT NULL COMMENT E'',
	"next_val" BIGINT NOT NULL COMMENT E'',
	"increment_factor" INTEGER NULL DEFAULT 1 COMMENT E'',
	PRIMARY KEY ("sequence_name")
);

-- Dumping data for table public.auto_sequence: 0 rows
/*!40000 ALTER TABLE "auto_sequence" DISABLE KEYS */;
INSERT INTO "auto_sequence" ("sequence_name", "init_val", "next_val", "increment_factor") VALUES
	(E'prime_seq', 1, 1, 1);
/*!40000 ALTER TABLE "auto_sequence" ENABLE KEYS */;

-- Dumping structure for table public.contact_query
CREATE TABLE IF NOT EXISTS "contact_query" (
	"query_id" BIGINT NOT NULL COMMENT E'',
	"contact_email_address" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"contact_name" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"query_subject" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"query_txt" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"user_id" BIGINT NULL DEFAULT NULL COMMENT E'',
	"user_type_cd" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	PRIMARY KEY ("query_id")
);

-- Dumping data for table public.contact_query: 0 rows
/*!40000 ALTER TABLE "contact_query" DISABLE KEYS */;
INSERT INTO "contact_query" ("query_id", "contact_email_address", "contact_name", "query_subject", "query_txt", "user_id", "user_type_cd") VALUES
	(1, E'shramdc@gmail.com', E'Ram Sharma', E'hello', E'I want to connect', NULL, NULL);
/*!40000 ALTER TABLE "contact_query" ENABLE KEYS */;

-- Dumping structure for table public.employee_tb
CREATE TABLE IF NOT EXISTS "employee_tb" (
	"employee_id" BIGINT NOT NULL COMMENT E'',
	"employee_first_name" CHARACTER VARYING(255) NOT NULL COMMENT E'',
	"employee_middle_name" CHARACTER VARYING(255) NULL DEFAULT NULL COMMENT E'',
	"employee_last_name" CHARACTER VARYING(255) NULL DEFAULT NULL COMMENT E'',
	"employee_age" BIT(1) NOT NULL COMMENT E'',
	"employee_gender" CHARACTER(1) NULL DEFAULT NULL COMMENT E'',
	"employee_contact_detail_id" BIGINT NULL DEFAULT NULL COMMENT E'',
	"employee_address_detail_id" BIGINT NULL DEFAULT NULL COMMENT E'',
	PRIMARY KEY ("employee_id")
);

-- Dumping data for table public.employee_tb: 0 rows
/*!40000 ALTER TABLE "employee_tb" DISABLE KEYS */;
/*!40000 ALTER TABLE "employee_tb" ENABLE KEYS */;

-- Dumping structure for table public.employer_tb
CREATE TABLE IF NOT EXISTS "employer_tb" (
	"employer_id" BIGINT NOT NULL COMMENT E'',
	"employer_name" CHARACTER VARYING(255) NOT NULL COMMENT E'',
	"is_active" BOOLEAN NOT NULL DEFAULT true COMMENT E'',
	PRIMARY KEY ("employer_id")
);

-- Dumping data for table public.employer_tb: 0 rows
/*!40000 ALTER TABLE "employer_tb" DISABLE KEYS */;
/*!40000 ALTER TABLE "employer_tb" ENABLE KEYS */;

-- Dumping structure for table public.guest_user_info
CREATE TABLE IF NOT EXISTS "guest_user_info" (
	"user_id" BIGINT NOT NULL COMMENT E'',
	"user_type_cd" CHARACTER VARYING(10) NOT NULL DEFAULT 'GUEST'::character varying COMMENT E'',
	PRIMARY KEY ("user_id")
);

-- Dumping data for table public.guest_user_info: 0 rows
/*!40000 ALTER TABLE "guest_user_info" DISABLE KEYS */;
/*!40000 ALTER TABLE "guest_user_info" ENABLE KEYS */;

-- Dumping structure for table public.login_tracker
CREATE TABLE IF NOT EXISTS "login_tracker" (
	"login_tracker_id" BIGINT NOT NULL COMMENT E'',
	"user_id" BIGINT NOT NULL COMMENT E'',
	"login_time" TIMESTAMP WITHOUT TIME ZONE NOT NULL COMMENT E'',
	"logout_time" TIMESTAMP WITHOUT TIME ZONE NULL DEFAULT NULL COMMENT E'',
	PRIMARY KEY ("login_tracker_id")
);

-- Dumping data for table public.login_tracker: 0 rows
/*!40000 ALTER TABLE "login_tracker" DISABLE KEYS */;
/*!40000 ALTER TABLE "login_tracker" ENABLE KEYS */;

-- Dumping structure for table public.registered_user_info
CREATE TABLE IF NOT EXISTS "registered_user_info" (
	"user_id" BIGINT NOT NULL COMMENT E'',
	"user_type_cd" CHARACTER VARYING(10) NOT NULL DEFAULT 'REG'::character varying COMMENT E'',
	"user_first_name" CHARACTER VARYING(255) NOT NULL COMMENT E'',
	"user_middle_name" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"user_last_name" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"user_email_address" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"user_phone_number" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"user_registeration_date" TIMESTAMP WITHOUT TIME ZONE NOT NULL COMMENT E'',
	PRIMARY KEY ("user_id")
);

-- Dumping data for table public.registered_user_info: 0 rows
/*!40000 ALTER TABLE "registered_user_info" DISABLE KEYS */;
/*!40000 ALTER TABLE "registered_user_info" ENABLE KEYS */;

-- Dumping structure for table public.school_book_address
CREATE TABLE IF NOT EXISTS "school_book_address" (
	"id" BIGINT NOT NULL COMMENT E'',
	"address_text_1" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"address_text_2" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"address_text_3" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"address_text_4" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"student_id" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	PRIMARY KEY ("id")
);

-- Dumping data for table public.school_book_address: 0 rows
/*!40000 ALTER TABLE "school_book_address" DISABLE KEYS */;
/*!40000 ALTER TABLE "school_book_address" ENABLE KEYS */;

-- Dumping structure for table public.school_book_attendance
CREATE TABLE IF NOT EXISTS "school_book_attendance" (
	"id" BIGINT NOT NULL COMMENT E'',
	"student_id" BIGINT NOT NULL COMMENT E'',
	"month" BIGINT NOT NULL COMMENT E'',
	"year" BIGINT NOT NULL COMMENT E'',
	"date" BIGINT NOT NULL COMMENT E'',
	"status" BIGINT NOT NULL COMMENT E'',
	PRIMARY KEY ("id")
);

-- Dumping data for table public.school_book_attendance: 0 rows
/*!40000 ALTER TABLE "school_book_attendance" DISABLE KEYS */;
/*!40000 ALTER TABLE "school_book_attendance" ENABLE KEYS */;

-- Dumping structure for table public.school_book_fees
CREATE TABLE IF NOT EXISTS "school_book_fees" (
	"id" BIGINT NOT NULL COMMENT E'',
	"student_id" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"month" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"year" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"day" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"due_date" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"submit_date" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"total_amount" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"paid_amount" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"due_amount" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"previous_balance_amt" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	PRIMARY KEY ("id")
);

-- Dumping data for table public.school_book_fees: 0 rows
/*!40000 ALTER TABLE "school_book_fees" DISABLE KEYS */;
/*!40000 ALTER TABLE "school_book_fees" ENABLE KEYS */;

-- Dumping structure for table public.school_book_holidays
CREATE TABLE IF NOT EXISTS "school_book_holidays" (
	"id" BIGINT NOT NULL COMMENT E'',
	"day" BIGINT NOT NULL COMMENT E'',
	"month" BIGINT NOT NULL COMMENT E'',
	"year" BIGINT NOT NULL COMMENT E'',
	"date" BIGINT NOT NULL COMMENT E'',
	PRIMARY KEY ("id")
);

-- Dumping data for table public.school_book_holidays: 0 rows
/*!40000 ALTER TABLE "school_book_holidays" DISABLE KEYS */;
/*!40000 ALTER TABLE "school_book_holidays" ENABLE KEYS */;

-- Dumping structure for table public.school_book_student
CREATE TABLE IF NOT EXISTS "school_book_student" (
	"id" BIGINT NOT NULL COMMENT E'',
	"first_name" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"last_name" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"middle_name" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"date_of_birth" TIMESTAMP WITHOUT TIME ZONE NULL DEFAULT NULL COMMENT E'',
	"admission_date" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"email_address" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"primary_contact" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"secondary_contact" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"father_first_name" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"father_last_name" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"father_middle_name" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"mother_first_name" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"mother_last_name" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"mother_middle_name" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"guardian_first_name" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"guardian_last_name" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"guardian_middle_name" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"admission_class" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"current_class" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"status" BIGINT NOT NULL COMMENT E'',
	"tc_date" BIGINT NOT NULL COMMENT E'',
	PRIMARY KEY ("id")
);

-- Dumping data for table public.school_book_student: 0 rows
/*!40000 ALTER TABLE "school_book_student" DISABLE KEYS */;
/*!40000 ALTER TABLE "school_book_student" ENABLE KEYS */;

-- Dumping structure for table public.social_poll
CREATE TABLE IF NOT EXISTS "social_poll" (
	"id" BIGINT NOT NULL COMMENT E'',
	"closed_on_dt" TIMESTAMP WITHOUT TIME ZONE NULL DEFAULT NULL COMMENT E'',
	"created_on_dt" TIMESTAMP WITHOUT TIME ZONE NULL DEFAULT NULL COMMENT E'',
	"edit_by_user_id" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"edited_on_dt" TIMESTAMP WITHOUT TIME ZONE NULL DEFAULT NULL COMMENT E'',
	"status_now" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"subject" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"submit_by_user_id" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"submitted_on_dt" TIMESTAMP WITHOUT TIME ZONE NULL DEFAULT NULL COMMENT E'',
	PRIMARY KEY ("id")
);

-- Dumping data for table public.social_poll: 0 rows
/*!40000 ALTER TABLE "social_poll" DISABLE KEYS */;
INSERT INTO "social_poll" ("id", "closed_on_dt", "created_on_dt", "edit_by_user_id", "edited_on_dt", "status_now", "subject", "submit_by_user_id", "submitted_on_dt") VALUES
	(5003, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'Should the Human Being step up!', E'30001', E'2017-03-06 23:08:14'),
	(5004, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'Will this war stop!', E'30001', E'2017-03-06 23:08:14'),
	(5005, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'Should Trumt step down!', E'30001', E'2017-03-06 23:08:14'),
	(5006, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'Would there be Destruction again!', E'30001', E'2017-03-06 23:08:14'),
	(5007, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'Is Gay marriage legal!', E'30001', E'2017-03-06 23:08:14'),
	(5008, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14'),
	(5009, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'Now and Then!', E'30001', E'2017-03-06 23:08:14'),
	(5010, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'Are there perfect human beings!', E'30001', E'2017-03-06 23:08:14'),
	(5011, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'Is LOve true!', E'30001', E'2017-03-06 23:08:14'),
	(5012, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'Why Mind takes over your fear!', E'30001', E'2017-03-06 23:08:14'),
	(5013, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14'),
	(5014, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14'),
	(5015, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14'),
	(5016, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14'),
	(5017, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14'),
	(5018, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14'),
	(5019, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14'),
	(5020, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14'),
	(5021, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14'),
	(5022, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14'),
	(5023, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14'),
	(5024, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14'),
	(5025, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14'),
	(5026, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14'),
	(5027, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14'),
	(5028, E'2017-03-06 23:08:14', E'2017-03-06 23:08:14', E'30001', E'2017-03-06 23:08:14', E'ALIVE', E'What should be the life!', E'30001', E'2017-03-06 23:08:14');
/*!40000 ALTER TABLE "social_poll" ENABLE KEYS */;

-- Dumping structure for table public.social_poll_option
CREATE TABLE IF NOT EXISTS "social_poll_option" (
	"id" CHARACTER VARYING(255) NOT NULL COMMENT E'',
	"social_poll_id" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"option_txt" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	PRIMARY KEY ("id")
);

-- Dumping data for table public.social_poll_option: 0 rows
/*!40000 ALTER TABLE "social_poll_option" DISABLE KEYS */;
INSERT INTO "social_poll_option" ("id", "social_poll_id", "option_txt") VALUES
	(E'300010', E'5006', E'Yes'),
	(E'300011', E'5006', E'NO'),
	(E'300012', E'5007', E'YES'),
	(E'300013', E'5007', E'NO'),
	(E'300014', E'5008', E'Yes'),
	(E'300015', E'5008', E'NO'),
	(E'300016', E'5009', E'YES'),
	(E'300017', E'5009', E'NO'),
	(E'300018', E'5010', E'Yes'),
	(E'300019', E'5010', E'NO'),
	(E'300020', E'5011', E'YES'),
	(E'300021', E'5011', E'NO');
/*!40000 ALTER TABLE "social_poll_option" ENABLE KEYS */;

-- Dumping structure for table public.social_poll_response
CREATE TABLE IF NOT EXISTS "social_poll_response" (
	"id" CHARACTER VARYING(255) NOT NULL COMMENT E'',
	"social_poll_id" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"social_poll_option_id" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"response_by_user_id" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"response_on_dt" TIMESTAMP WITHOUT TIME ZONE NULL DEFAULT NULL COMMENT E'',
	"response_edit_on_dt" TIMESTAMP WITHOUT TIME ZONE NULL DEFAULT NULL COMMENT E'',
	"response_withdraw_dt" TIMESTAMP WITHOUT TIME ZONE NULL DEFAULT NULL COMMENT E'',
	PRIMARY KEY ("id")
);

-- Dumping data for table public.social_poll_response: 0 rows
/*!40000 ALTER TABLE "social_poll_response" DISABLE KEYS */;
INSERT INTO "social_poll_response" ("id", "social_poll_id", "social_poll_option_id", "response_by_user_id", "response_on_dt", "response_edit_on_dt", "response_withdraw_dt") VALUES
	(E'200001', E'5006', E'300010', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200002', E'5006', E'300010', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200003', E'5006', E'300010', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200004', E'5006', E'300010', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200005', E'5006', E'300010', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200006', E'5006', E'300010', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200007', E'5006', E'300010', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200008', E'5006', E'300010', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200009', E'5006', E'300010', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200010', E'5006', E'300010', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200011', E'5006', E'300011', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200012', E'5006', E'300011', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200013', E'5006', E'300011', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200014', E'5006', E'300011', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200015', E'5006', E'300011', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200016', E'5006', E'300011', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200017', E'5006', E'300011', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200018', E'5006', E'300011', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200019', E'5006', E'300011', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200020', E'5006', E'300011', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29'),
	(E'200021', E'5006', E'300010', E'30001', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29', E'2017-03-06 23:28:29');
/*!40000 ALTER TABLE "social_poll_response" ENABLE KEYS */;

-- Dumping structure for table public.user_info
CREATE TABLE IF NOT EXISTS "user_info" (
	"id" CHARACTER VARYING(255) NOT NULL COMMENT E'',
	"name" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"email" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"passwd" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	"phone" CHARACTER VARYING(255) NULL DEFAULT NULL::character varying COMMENT E'',
	PRIMARY KEY ("id")
);

-- Dumping data for table public.user_info: 0 rows
/*!40000 ALTER TABLE "user_info" DISABLE KEYS */;
INSERT INTO "user_info" ("id", "name", "email", "passwd", "phone") VALUES
	(E'40009', E'test_user_1', E'testuser1@test.com', E'root', E'8096745368'),
	(E'40010', E'test_user_2', E'testuser2@test.com', E'root', E'8043245368'),
	(E'40011', E'test_user_3', E'testuser3@test.com', E'root', E'8023145368'),
	(E'40012', E'test_user_4', E'testuser4@test.com', E'root', E'8564645368'),
	(E'40013', E'test_user_5', E'testuser5@test.com', E'root', E'3432445368'),
	(E'40014', E'test_user_6', E'testuser6@test.com', E'root', E'8093432432'),
	(E'40015', E'test_user_7', E'testuser7@test.com', E'root', E'8093423432'),
	(E'40016', E'test_user_8', E'testuser8@test.com', E'root', E'8096744234'),
	(E'40017', E'test_user_9', E'testuser9@test.com', E'root', E'8096745654'),
	(E'40018', E'test_user_10', E'testuser10@test.com', E'root', E'8096744534');
/*!40000 ALTER TABLE "user_info" ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
