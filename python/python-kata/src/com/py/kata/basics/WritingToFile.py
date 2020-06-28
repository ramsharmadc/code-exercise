def write_some_file():
    book = open("E:\dev-server\goodpluto-dev-tomcat-1\logs\catalina.2016-09-25.log", 'a')
    book.write("File handling in Python is fun!!\n")
    book.write("Absolutely fun!!\n")
    book.close()

    # book = open("E:\dev-server\goodpluto-dev-tomcat-1\logs\catalina.2016-09-25.log", 'r')
    #
    # for line in book:
    #     print(line)

    book = open("E:\dev-server\goodpluto-dev-tomcat-1\logs\catalina.2016-09-25.log", 'a')
    book.write("File I/O in Python is fun!!\n")
    book.write("Absolutely fun!!\n")
    book.close()

    book = open("E:\dev-server\goodpluto-dev-tomcat-1\logs\catalina.2016-09-25.log", 'r')

    for line in book:
        print(line)


write_some_file()
