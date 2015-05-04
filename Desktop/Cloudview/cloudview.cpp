#include "cloudview.h"
#include "ui_cloudview.h"
#include <QFileDialog>
#include <QMessageBox>

Cloudview::Cloudview(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::Cloudview)
{
    ui->setupUi(this);
}

Cloudview::~Cloudview()
{
    delete ui;
}



void Cloudview::on_btnClvFolder_clicked()
{
//    QString folderName = QFileDialog::getExistingDirectory(
//                this,
//                tr("Choisir un dossier"),
//                "C://",
//                QFileDialog::ShowDirsOnly | QFileDialog::DontResolveSymlinks
//                );
//    QMessageBox::information(this,tr("dossier choisi"),folderName);
}

void Cloudview::on_btnSouscription_clicked()
{

}
