Write-Host "================================" -ForegroundColor Cyan
Write-Host " AgentX API DIAGNOSTIC CLEAN" -ForegroundColor Cyan
Write-Host "================================`n" -ForegroundColor Cyan

Write-Host "[1] Port Check..." -ForegroundColor Yellow
netstat -ano | findstr :8080

Write-Host "`n[2] API Test GET..." -ForegroundColor Yellow
try {
    $res = Invoke-RestMethod -Uri "http://localhost:8080/api/jobs" -Method GET
    Write-Host "OK:" -ForegroundColor Green
    $res
}
catch {
    Write-Host "ERROR:" -ForegroundColor Red
    Write-Host $_.Exception.Message
}

Write-Host "`n[3] API Test POST..." -ForegroundColor Yellow
try {
    $body = @{ software = @("Python") } | ConvertTo-Json

    $res2 = Invoke-RestMethod `
        -Uri "http://localhost:8080/api/jobs" `
        -Method POST `
        -Body $body `
        -ContentType "application/json"

    Write-Host "OK:" -ForegroundColor Green
    $res2
}
catch {
    Write-Host "ERROR:" -ForegroundColor Red
    Write-Host $_.Exception.Message
}

Write-Host "`n================================"
Write-Host " DONE"
Write-Host "================================"