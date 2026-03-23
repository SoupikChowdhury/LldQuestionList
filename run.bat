@echo off
echo ========================================
echo   Compiling Inventory Management System
echo ========================================
javac Main.java Warehouse.java CommonEnum\InventoryOperation.java CommonEnum\ProductCategory.java ProductsFactory\Product.java ProductsFactory\ProductFactory.java ProductsFactory\ConcreteProducts\ElectronicProduct.java ProductsFactory\ConcreteProducts\ClothingProduct.java ProductReplenishmentStrategies\ReplenishmentStrategy.java ProductReplenishmentStrategies\ConcreateReplenishmentStrategies\BulkInOrderStrategy.java ProductReplenishmentStrategies\ConcreateReplenishmentStrategies\JustInTimeStrategy.java

if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b %errorlevel%
)

echo.
echo ========================================
echo   Running Inventory Management System
echo ========================================
echo.
java Main

echo.
pause
