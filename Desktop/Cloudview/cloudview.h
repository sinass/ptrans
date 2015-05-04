#ifndef CLOUDVIEW_H
#define CLOUDVIEW_H

#include <QMainWindow>

namespace Ui {
class Cloudview;
}

class Cloudview : public QMainWindow
{
    Q_OBJECT

public:
    explicit Cloudview(QWidget *parent = 0);
    ~Cloudview();

private slots:
    void on_btnClvFolder_clicked();

    void on_btnSouscription_clicked();

private:
    Ui::Cloudview *ui;
};

#endif // CLOUDVIEW_H
