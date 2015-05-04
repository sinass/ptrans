#include "cloudview.h"
#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    Cloudview w;
    w.show();

    return a.exec();
}
