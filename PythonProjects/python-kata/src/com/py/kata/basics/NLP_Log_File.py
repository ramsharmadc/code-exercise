def read_logs():
    log_file = open("C:\\Users\\ramsh\\Desktop\\NLP-text.txt", 'r')

    my_sql_connection_opened = check_word_hits("Starting new MySql Connection thread from Connection pool.", log_file)
    print("MySql connection started for " + str(my_sql_connection_opened) + " times")

    log_file.seek(0)
    my_sql_connection_opened = check_word_hits("CACHE HIT", log_file)
    print("Cache hit for " + str(my_sql_connection_opened) + " times")


def check_word_hits(word, file):
    j = 0
    for line in file:
        i = str(line).find(word)
        if i > 0:
            j += 1
            # print(line)

            # print("word hit=" + str(i))
    return j


read_logs()
