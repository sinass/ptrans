/********************************************************************************
** Form generated from reading UI file 'cloudview.ui'
**
** Created by: Qt User Interface Compiler version 5.4.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_CLOUDVIEW_H
#define UI_CLOUDVIEW_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QFrame>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QToolBar>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_Cloudview
{
public:
    QAction *actionCompte;
    QAction *actionFichiers;
    QWidget *centralWidget;
    QHBoxLayout *horizontalLayout;
    QGridLayout *gridLayout;
    QFrame *frameAccount;
    QHBoxLayout *horizontalLayout_2;
    QVBoxLayout *verticalLayout;
    QPushButton *btnSouscription;
    QPushButton *btnClvFolder;
    QFrame *frameConnected;
    QHBoxLayout *horizontalLayout_4;
    QToolBar *mainToolBar;
    QStatusBar *statusBar;

    void setupUi(QMainWindow *Cloudview)
    {
        if (Cloudview->objectName().isEmpty())
            Cloudview->setObjectName(QStringLiteral("Cloudview"));
        Cloudview->resize(624, 338);
        Cloudview->setToolButtonStyle(Qt::ToolButtonTextUnderIcon);
        Cloudview->setDocumentMode(false);
        actionCompte = new QAction(Cloudview);
        actionCompte->setObjectName(QStringLiteral("actionCompte"));
        QIcon icon;
        icon.addFile(QStringLiteral("../../../../../Downloads/MyIcons/png/user168.png"), QSize(), QIcon::Normal, QIcon::Off);
        actionCompte->setIcon(icon);
        actionFichiers = new QAction(Cloudview);
        actionFichiers->setObjectName(QStringLiteral("actionFichiers"));
        QIcon icon1;
        icon1.addFile(QStringLiteral("../../../../../Downloads/MyIcons/png/send4.png"), QSize(), QIcon::Normal, QIcon::Off);
        actionFichiers->setIcon(icon1);
        centralWidget = new QWidget(Cloudview);
        centralWidget->setObjectName(QStringLiteral("centralWidget"));
        horizontalLayout = new QHBoxLayout(centralWidget);
        horizontalLayout->setSpacing(6);
        horizontalLayout->setContentsMargins(11, 11, 11, 11);
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        gridLayout = new QGridLayout();
        gridLayout->setSpacing(6);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        frameAccount = new QFrame(centralWidget);
        frameAccount->setObjectName(QStringLiteral("frameAccount"));
        frameAccount->setStyleSheet(QStringLiteral(""));
        frameAccount->setFrameShape(QFrame::StyledPanel);
        frameAccount->setFrameShadow(QFrame::Raised);
        horizontalLayout_2 = new QHBoxLayout(frameAccount);
        horizontalLayout_2->setSpacing(6);
        horizontalLayout_2->setContentsMargins(11, 11, 11, 11);
        horizontalLayout_2->setObjectName(QStringLiteral("horizontalLayout_2"));
        verticalLayout = new QVBoxLayout();
        verticalLayout->setSpacing(6);
        verticalLayout->setObjectName(QStringLiteral("verticalLayout"));
        btnSouscription = new QPushButton(frameAccount);
        btnSouscription->setObjectName(QStringLiteral("btnSouscription"));

        verticalLayout->addWidget(btnSouscription);

        btnClvFolder = new QPushButton(frameAccount);
        btnClvFolder->setObjectName(QStringLiteral("btnClvFolder"));

        verticalLayout->addWidget(btnClvFolder);


        horizontalLayout_2->addLayout(verticalLayout);


        gridLayout->addWidget(frameAccount, 0, 0, 1, 1);

        frameConnected = new QFrame(centralWidget);
        frameConnected->setObjectName(QStringLiteral("frameConnected"));
        frameConnected->setStyleSheet(QStringLiteral(""));
        frameConnected->setFrameShape(QFrame::StyledPanel);
        frameConnected->setFrameShadow(QFrame::Raised);
        horizontalLayout_4 = new QHBoxLayout(frameConnected);
        horizontalLayout_4->setSpacing(6);
        horizontalLayout_4->setContentsMargins(11, 11, 11, 11);
        horizontalLayout_4->setObjectName(QStringLiteral("horizontalLayout_4"));

        gridLayout->addWidget(frameConnected, 0, 1, 1, 1);


        horizontalLayout->addLayout(gridLayout);

        Cloudview->setCentralWidget(centralWidget);
        mainToolBar = new QToolBar(Cloudview);
        mainToolBar->setObjectName(QStringLiteral("mainToolBar"));
        Cloudview->addToolBar(Qt::TopToolBarArea, mainToolBar);
        statusBar = new QStatusBar(Cloudview);
        statusBar->setObjectName(QStringLiteral("statusBar"));
        Cloudview->setStatusBar(statusBar);

        mainToolBar->addAction(actionCompte);
        mainToolBar->addAction(actionFichiers);

        retranslateUi(Cloudview);

        QMetaObject::connectSlotsByName(Cloudview);
    } // setupUi

    void retranslateUi(QMainWindow *Cloudview)
    {
        Cloudview->setWindowTitle(QApplication::translate("Cloudview", "Cloudview", 0));
        actionCompte->setText(QApplication::translate("Cloudview", "Compte", 0));
#ifndef QT_NO_TOOLTIP
        actionCompte->setToolTip(QApplication::translate("Cloudview", "Les param\303\250tres de Compte", 0));
#endif // QT_NO_TOOLTIP
        actionFichiers->setText(QApplication::translate("Cloudview", "Fichiers", 0));
#ifndef QT_NO_TOOLTIP
        actionFichiers->setToolTip(QApplication::translate("Cloudview", "mes fichiers", 0));
#endif // QT_NO_TOOLTIP
        btnSouscription->setText(QApplication::translate("Cloudview", "Demander une souscription", 0));
        btnClvFolder->setText(QApplication::translate("Cloudview", "Changer de dossier CloudView", 0));
    } // retranslateUi

};

namespace Ui {
    class Cloudview: public Ui_Cloudview {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CLOUDVIEW_H
